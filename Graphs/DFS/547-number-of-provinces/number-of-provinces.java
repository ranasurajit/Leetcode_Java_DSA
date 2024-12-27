class Solution {
    /**
     * TC: O(V x V + V x E) ~ O(V x (V + E))
     * SC: O(2 x V) ~ O(V)
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // TC: O(V ^ 2), SC: O(V)
        Map<Integer, ArrayList<Integer>> adj = createGraph(isConnected, n);
        boolean[] visited = new boolean[n]; // SC: O(V)
        int provinces = 0;
        for (int i = 0; i < n; i++) {       // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, visited, adj);  // TC: O(E)
                provinces++;
            }
        }
        return provinces;
    }

    /**
     * TC: O(E)
     * SC: O(E)
     */
    private void dfsGraph(int u, boolean[] visited, Map<Integer, ArrayList<Integer>> adj) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsGraph(v, visited, adj);
            }
        }
    }

    /**
     * TC: O(V ^ 2 + V) ~ O(V ^ 2)
     * SC: O(V)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] isConnected, int n) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) { // TC: O(V)
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {     // TC: O(V)
            for (int j = 0; j < n; j++) { // TC: O(V)
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}
