class Solution {
    /**
     * Approach II : Using BFS Approach
     *
     * TC: O(2 x M + N) ~ O(M + N)
     * SC: O(3 x M +  2 x N) ~ O(M + N)
     *
     * Time Limit Exceeded (816 / 825 testcases passed)
     */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m = edges1.length + 1;
        int n = edges2.length + 1;
        Map<Integer, ArrayList<Integer>> adj1 = createGraph(edges1); // SC: O(M)
        Map<Integer, ArrayList<Integer>> adj2 = createGraph(edges2); // SC: O(N)

        // do a BFS traversal in Tree 2 to get the best counts of even nodes and odd nodes
        int evenNodesFromTree2 = bfsGraph(0, n, adj2, null); // TC: O(N), SC: O(N)
        int oddNodesFromTree2 = n - evenNodesFromTree2;
        int bestContribution = Math.max(evenNodesFromTree2, oddNodesFromTree2);

        boolean[] included = new boolean[m]; // SC: O(M)
        // do a BFS traversal in Tree 1 and store the even nodes and odd nodes in the above array 
        int evenNodesFromTree1 = bfsGraph(0, m, adj1, included); // TC: O(M), SC: O(M)
        int oddNodesFromTree1 = m - evenNodesFromTree1;

        int[] result = new int[m];
        for (int i = 0; i < m; i++) { // TC: O(M)
            if (included[i]) {
                result[i] = evenNodesFromTree1 + bestContribution;
            } else {
                result[i] = oddNodesFromTree1 + bestContribution;
            }
        }
        return result;
    }

    /**
     * Using BFS Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    private int bfsGraph(int src, int n, Map<Integer, ArrayList<Integer>> adj, boolean[] included) {
        boolean[] visited = new boolean[n]; // SC: O(N)
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(N)
        queue.offer(src);
        visited[src] = true;
        int count = 0;
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(2 x N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                if (included != null && (level & 1) == 0) {
                    included[u] = true;
                }
                for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
            if ((level & 1) == 0) {
                count += size;
            }
            level++;
        }
        return count;
    }

    /**
     * Approach I : Using DFS Approach
     *
     * TC: O(M ^ 2 + N ^ 2 + M) ~ O(M ^ 2 + N ^ 2)
     * SC: O(M + N)
     *
     * Time Limit Exceeded (816 / 825 testcases passed)
     */
    public int[] maxTargetNodesApproachI(int[][] edges1, int[][] edges2) {
        int m = edges1.length + 1;
        int n = edges2.length + 1;
        Map<Integer, ArrayList<Integer>> adj1 = createGraph(edges1); // SC: O(M)
        Map<Integer, ArrayList<Integer>> adj2 = createGraph(edges2); // SC: O(N)
        int[] result = new int[m];
        for (int i = 0; i < m; i++) { // TC: O(M)
            // result[i] will be number of nodes pointing to it from Tree 1 which are at a even distance
            int[] edgeCount = { 0 };
            // removing extra count when edgeCount[0] = 0
            result[i] = dfsGraph(i, -1, adj1, edgeCount, true) - 1; // TC: O(M)
        }
        int maxNodes = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            // result[i] will be number of nodes pointing to it from Tree 1 which are at a odd distance
            int[] edgeCount = { 0 };
            // removing extra count when edgeCount[0] is not needed as we need odd distances
            maxNodes = Math.max(maxNodes, dfsGraph(i, -1, adj2, edgeCount, false)); // TC: O(N)
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            // 1 is added for extra edge connection
            result[i] = result[i] + maxNodes + 1;
        }
        return result;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(M + (M + 1)) ~ O(M)
     * SC: O(M)
     */
    private int dfsGraph(int u, int parent, Map<Integer, ArrayList<Integer>> adj,
        int[] edgeCount, boolean evenEdges) {
        int count = 0;
        if (evenEdges) {
            if ((edgeCount[0] & 1) == 0) {
                count = 1;
            }
        } else {
            if ((edgeCount[0] & 1) != 0) {
                count = 1;
            }
        }
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (v != parent) {
                count += dfsGraph(v, u, adj, new int[] { edgeCount[0] + 1 }, evenEdges);
            }
        }
        return count;
    }

    /**
     * Using Hasing Approach
     *
     * TC: O(M + (M + 1)) ~ O(M)
     * SC: O(M)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return adj;
    }
}
