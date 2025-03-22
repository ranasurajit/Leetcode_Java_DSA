class Solution {
    /**
     * Approach V : Using Disjoint Set Union Approach (Optimal Approach)
     *
     * TC: O(2 x V + E + E x α(V)) ~ O(E x α(V))
     * SC: O(3 x V) ~ O(V)
     *
     * where α(V) denotes Inverse Ackermann time complexity which is
     * much smaller than other commonly used time complexity of
     * O(1), O(log n), and O(n)
     */
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            parent[i] = i;
        }
        int[] vSize = new int[n]; // SC: O(V)
        Arrays.fill(vSize, 1);
        // creating connections by DSU and pre-computing size of each component
        for (int[] edge : edges) { // TC: O(E)
            unionBySize(edge[0], edge[1], parent, vSize);
        }
        Map<Integer, Integer> verEdgeMap = new HashMap<Integer, Integer>(); // SC: O(V)
        // looping over edges to find number of edges for each disconnected components
        for (int[] edge : edges) { // TC: O(E)
            int root = find(edge[0], parent); // TC: O(α(V))
            verEdgeMap.put(root, verEdgeMap.getOrDefault(root, 0) + 1);
        }
        // checking for complete connected components
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                int eCount = verEdgeMap.getOrDefault(i, 0);
                int vCount = vSize[i];
                if (eCount == (vCount * (vCount - 1)) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Using DSU : Find by Path Compression Approach
     *
     * TC: O(V)
     * SC: O(V)
     */
    private int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    /**
     * Using DSU : Union by Size Approach
     *
     * TC: O(2 x V) ~ O(V)
     * SC: O(1)
     */
    private void unionBySize(int x, int y, int[] parent, int[] vSize) {
        int xParent = find(x, parent); // TC: O(V)
        int yParent = find(y, parent); // TC: O(V)
        if (xParent == yParent) {
            return;
        }
        if (vSize[xParent] > vSize[yParent]) {
            parent[yParent] = xParent;
            vSize[xParent] += vSize[yParent];
        } else if (vSize[yParent] > vSize[xParent]) {
            parent[xParent] = yParent;
            vSize[yParent] += vSize[xParent];
        } else {
            parent[yParent] = xParent;
            vSize[xParent] += vSize[yParent];
        }
    }

    /**
     * Approach IV : Using BFS Approach (Better Approach)
     *
     * TC: O(3 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public int countCompleteComponentsApproachIV(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                int[] verticesEdges = { 0, 0 }; // SC: O(1)
                bfsGraph(i, adj, visited, verticesEdges); // TC: O(V + E), SC: O(V)
                // for complete components e = (v * (v - 1)) / 2
                if (verticesEdges[1] / 2 == (verticesEdges[0] * (verticesEdges[0] - 1)) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private void bfsGraph(int s, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] verticesEdges) {
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(V)
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            verticesEdges[0]++;
            verticesEdges[1] += adj.getOrDefault(u, new ArrayList<Integer>()).size();
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    /**
     * Approach III : Using DFS Approach (Better Approach)
     *
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public int countCompleteComponentsApproachIII(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                int[] verticesEdges = { 0, 0 }; // SC: O(1)
                dfsGraphAgain(i, adj, visited, verticesEdges); // TC: O(E), SC: O(V)
                // for complete components e = (v * (v - 1)) / 2
                if (verticesEdges[1] / 2 == (verticesEdges[0] * (verticesEdges[0] - 1)) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraphAgain(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] verticesEdges) {
        visited[u] = true;
        verticesEdges[0]++;
        verticesEdges[1] += adj.getOrDefault(u, new ArrayList<Integer>()).size();
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraphAgain(v, adj, visited, verticesEdges);
            }
        }
    }

    /**
     * Approach II : Using DFS Approach
     *
     * TC: O(4 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public int countCompleteComponentsApproachII(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                Set<Integer> compSet = new HashSet<Integer>(); // SC: O(V)
                dfsGraphComponent(i, adj, visited, compSet); // TC: O(E), SC: O(V)
                if (isCompleteComponent(compSet, adj)) { // TC: O(V), SC: O(1)
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(V)
     * SC: O(1)
     */
    private boolean isCompleteComponent(Set<Integer> compSet,
        Map<Integer, ArrayList<Integer>> adj) {
        for (Integer node : compSet) {
            if (adj.getOrDefault(node, new ArrayList<Integer>()).size() 
                != compSet.size() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraphComponent(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, Set<Integer> compSet) {
        visited[u] = true;
        compSet.add(u);
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraphComponent(v, adj, visited, compSet);
            }
        }
    }

    /**
     * Approach I : Using Indegrees and DFS Approach
     *
     * TC: O(4 x V + 2 x E) ~ O(V + E)
     * SC: O(5 x V + E) ~ O(V + E)
     */
    public int countCompleteComponentsApproachI(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        int[] indegrees = new int[n]; // SC: O(V)
        int[] componentIndices = new int[n]; // SC: O(V)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
            indegrees[edge[1]]++;
            indegrees[edge[0]]++;
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V + E)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, componentIndices, count);
                count++;
            }
        }
        int incomplete = 0;
        Map<Integer, List<Integer>> compMap = new HashMap<Integer, List<Integer>>(); // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!compMap.containsKey(componentIndices[i])) {
                compMap.put(componentIndices[i], 
                    Arrays.asList(0, Integer.MAX_VALUE));
            }
            compMap.get(componentIndices[i]).
                set(0, compMap.get(componentIndices[i]).get(0) + 1);
            compMap.get(componentIndices[i]).
                set(1, Math.min(compMap.get(componentIndices[i]).get(1), indegrees[i]));
        }
        for (Integer key : compMap.keySet()) { // TC: O(V)
            List<Integer> comp = compMap.get(key);
            // If minimum indegree < number of vertices per component - 1 then it is incomplete
            if (comp.get(1) < comp.get(0) - 1) {
                incomplete++;
            }
        }
        return count - incomplete;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] componentIndices, int count) {
        visited[u] = true;
        componentIndices[u] = count;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, componentIndices, count);
            }
        }
    }
}
