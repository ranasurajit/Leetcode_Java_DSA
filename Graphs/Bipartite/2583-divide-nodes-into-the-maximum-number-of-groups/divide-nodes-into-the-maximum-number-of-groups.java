class Solution {
    /**
     * TC: O(2 x V x (V + E)) ~ O(V x (V + E))
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public int magnificentSets(int n, int[][] edges) {
        // create adjacency list
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) {
            // converting 1-based nodes to 0-based index
            adj.computeIfAbsent(edge[0] - 1, 
                k -> new ArrayList<Integer>()).add(edge[1] - 1);
            adj.computeIfAbsent(edge[1] - 1, 
                k -> new ArrayList<Integer>()).add(edge[0] - 1);
        }
        // check if the graph can be divided into groups - using Bipartite check
        boolean isPartitite = checkDFSIfBipartite(n, adj); // TC: O(V + E), SC: O(V)
        if (!isPartitite) {
            // not possible to group at all
            return -1;
        }
        /**
         * now we need to get maximum levels than is possible by doing
         * level order traversal (BFS) from all nodes
         */
        int[] levels = new int[n];          // SC: O(V)
        int maxGroups = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            levels[i] = bfsGraph(i, adj, n); // TC: O(V + E), SC: O(V)
            maxGroups = Math.max(maxGroups, levels[i]);
        }
        // calculate maximum levels from each disconnected components
        int maxGroupsComponent = 0;
        boolean[] visited = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                                      // TC: O(V + E), SC: O(V)
                maxGroupsComponent += dfsMaxLevelsGraph(i, adj, visited, levels);
            }
        }
        return maxGroupsComponent;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private int dfsMaxLevelsGraph(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] levels) {
        visited[u] = true;
        int maxLevels = levels[u];
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                maxLevels = Math.max(maxLevels, 
                    dfsMaxLevelsGraph(v, adj, visited, levels));
            }
        }
        return maxLevels;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private int bfsGraph(int src, Map<Integer, ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        visited[src] = true;
        int levels = 0; // max groups calculated in the BFS from a node
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer u = queue.poll();
                for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
            levels++;
        }
        return levels;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean checkDFSIfBipartite(int n, Map<Integer, ArrayList<Integer>> adj) {
        // creating colors array which would act as visited array
        int[] colors = new int[n]; // SC: O(N)
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !isBipartiteDFS(i, adj, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean isBipartiteDFS(int u, Map<Integer, ArrayList<Integer>> adj,
        int[] colors, int currentColor) {
        colors[u] = currentColor;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (colors[v] == colors[u]) {
                return false;
            }
            int altColor = 1 - currentColor;
            if (colors[v] == -1 && !isBipartiteDFS(v, adj, colors, altColor)) {
                return false;
            }
        }
        return true;
    }
}
