class Solution {

    private Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
    private int[] xors = null;
    private int[] inTime = null;
    private int[] outTime = null;
    private int time = 0;

    /**
     * Approach II : Using DFS + Hashing + Ancestor Finding Approach
     *
     * TC: O(2 x E) + O(V + E) + O(E x E) ~ O(E ^ 2)
     * SC: O(V + E) + O(V) + O(V) + O(V) + O(V) ~ O(V + E)
     *
     * Time Limit Exceeded (52 / 65 testcases passed)
     */
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int e = edges.length;
        adj = createAdjGraph(edges); // TC: O(2 x E), SC: O(V + E)
        xors = new int[n];    // SC: O(V) 
        inTime = new int[n];  // SC: O(V) 
        outTime = new int[n]; // SC: O(V) 
        // DFS traversal to populate xors, inTime and outTime
        dfsPreComputeGraph(0, -1, nums); // TC: O(V + E), SC: O(V)

        int minScore = Integer.MAX_VALUE;
        int totalXOR = xors[0];

        for (int i = 0; i < e - 1; i++) {      // TC: O(E)
            int a = edges[i][0];
            int b = edges[i][1];
            int u = isAncestor(a, b) ? b : a; // child after removing edges[i]
            for (int j = i + 1; j < e; j++) {  // TC: O(E)
                int[] edge2 = edges[i];
                int c = edges[j][0];
                int d = edges[j][1];
                int v = isAncestor(c, d) ? d : c; // child after removing edges[j]

                int x, y, z = 0;
                int minXOR = Integer.MAX_VALUE;
                int maxXOR = Integer.MIN_VALUE;
                if (isAncestor(u, v)) {
                    x = xors[v]; // xor of component rooted at v - 1st part
                    // xor of component rooted at u = (combined xor(u) exclude xor[v]) - 2nd part
                    y = xors[u] ^ xors[v];
                    // xor of component rooted at 0 = (excluding xor[u]) - 3rd part
                    z = totalXOR ^ xors[u];
                } else if (isAncestor(v, u)) {
                    x = xors[u]; // xor of component rooted at v - 1st part
                    // xor of component rooted at u = (combined xor(u) exclude xor[v]) - 2nd part
                    y = xors[v] ^ xors[u];
                    // xor of component rooted at 0 = (excluding xor[u]) - 3rd part
                    z = totalXOR ^ xors[v];
                } else {
                    x = xors[u]; // xor of component rooted at u - 1st part
                    // xor of component rooted at v - 2nd part
                    y = xors[v];
                    // xor of component rooted at 0 = (excluding xor[u] and xor[v]) - 3rd part
                    z = totalXOR ^ xors[u] ^ xors[v];
                }
                minXOR = Math.min(x, Math.min(y, z));
                maxXOR = Math.max(x, Math.max(y, z));
                minScore = Math.min(minScore, maxXOR - minXOR);
            }
        }
        return minScore;
    }

    /**
     * Checks if u is ancestor of v
     *
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[u] >= outTime[v];
    }

    /**
     * Using DFS Approach
     *
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsPreComputeGraph(int u, int parent, int[] nums) {
        inTime[u] = time++;
        xors[u] = nums[u];
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (v != parent) {
                dfsPreComputeGraph(v, u, nums);
                xors[u] ^= xors[v];
            }
        }
        outTime[u] = time++;
    }

    /**
     * Using Hashing Approach

     * TC: O(2 x E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<Integer>> createAdjGraph(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return adj;
    }

    /**
     * Approach I : Using DFS + Hashing Approach
     *
     * TC: O(2 x E) + O(E x E X V x (V + E)) ~ O(E ^ 2 x V ^ 2)
     * SC: O(V + E) + O(V) + O(V) ~ O(V + E)
     *
     * Time Limit Exceeded (52 / 65 testcases passed)
     */
    public int minimumScoreSimpleDFSBruteForce(int[] nums, int[][] edges) {
        int n = nums.length;
        int e = edges.length;
        Map<Integer, HashSet<Integer>> adj = createGraph(edges); // TC: O(2 x E), SC: O(V + E)
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < e - 1; i++) {      // TC: O(E)
            for (int j = i + 1; j < e; j++) {  // TC: O(E)
                removeEdges(adj, edges, i, j); // TC: O(1), SC: O(1)
                boolean[] visited = new boolean[n]; // SC: O(V) - reused
                int minXOR = Integer.MAX_VALUE;
                int maxXOR = Integer.MIN_VALUE;
                for (int k = 0; k < n; k++) {  // TC: O(V)
                    if (!visited[k]) {
                        int[] xor = { 0 };
                        dfsGraph(k, visited, adj, nums, xor); // TC: O(V + E), SC: O(V)
                        minXOR = Math.min(minXOR, xor[0]);
                        maxXOR = Math.max(maxXOR, xor[0]);
                    }
                }
                minScore = Math.min(minScore, maxXOR - minXOR);
                addEdges(adj, edges, i, j); // TC: O(1), SC: O(1)
            }
        }
        return minScore;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(int u, boolean[] visited, Map<Integer, HashSet<Integer>> adj,
        int[] nums, int[] xor) {
        visited[u] = true;
        xor[0] = xor[0] ^ nums[u];
        for (Integer v : adj.getOrDefault(u, new HashSet<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, visited, adj, nums, xor);
            }
        }
    }

    /**
     * Using Hashing Approach
     
     * TC: O(1)
     * SC: O(1)
     */
    private void addEdges(Map<Integer, HashSet<Integer>> adj, int[][] edges, int i, int j) {
        int[] edge1 = edges[i];
        int[] edge2 = edges[j];
        adj.get(edge1[0]).add(edge1[1]);
        adj.get(edge1[1]).add(edge1[0]);
        adj.get(edge2[0]).add(edge2[1]);
        adj.get(edge2[1]).add(edge2[0]);
    }

    /**
     * Using Hashing Approach
     
     * TC: O(1)
     * SC: O(1)
     */
    private void removeEdges(Map<Integer, HashSet<Integer>> adj, int[][] edges, int i, int j) {
        int[] edge1 = edges[i];
        int[] edge2 = edges[j];
        adj.get(edge1[0]).remove(edge1[1]);
        adj.get(edge1[1]).remove(edge1[0]);
        adj.get(edge2[0]).remove(edge2[1]);
        adj.get(edge2[1]).remove(edge2[0]);
    }

    /**
     * Using Hashing Approach

     * TC: O(2 x E)
     * SC: O(V + E)
     */
    private Map<Integer, HashSet<Integer>> createGraph(int[][] edges) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new HashSet<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new HashSet<Integer>()).add(edge[0]);
        }
        return adj;
    }
}
