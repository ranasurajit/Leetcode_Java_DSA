class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(N ^ 2) + O(N ^ 2) ~ O(N ^ 2)
     * SC: O(N ^ 2) + O(N)
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, ArrayList<Integer>> adj = createGraph(isConnected, n); // TC: O(N ^ 2), SC: O(N ^ 2)
        boolean[] visited = new boolean[n]; // SC: O(N)
        int provinces = 0;
        for (int i = 0; i < n; i++) {      // TC: O(N)
            if (!visited[i]) {
                dfsGraph(i, visited, adj); // TC: O(N ^ 2), SC: O(N)
                provinces++;
            }
        }
        return provinces;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(V + E) ~ O(N ^ 2)
     * SC: O(N)
     */
    private void dfsGraph(int u, boolean[] visited, Map<Integer, ArrayList<Integer>> adj) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, visited, adj);
            }
        }
    }

    /**
     * Using Hashing Approach
     *
     * TC: O(N x N) ~ O(N ^ 2)
     * SC: O(N x N) ~ O(N ^ 2)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] isConnected, int n) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N x N)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i != j && isConnected[i][j] == 1) {
                    adj.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }
        return adj;
    }
}
