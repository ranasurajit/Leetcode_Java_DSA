class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(isConnected, n);
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsGraph(adj, i, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfsGraph(HashMap<Integer, ArrayList<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsGraph(adj, v, visited);
            }
        }
    }

    private HashMap<Integer, ArrayList<Integer>> createGraph(int[][] isConnected, int n) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj.put(i, adj.getOrDefault(i, new ArrayList<Integer>()));
                adj.put(j, adj.getOrDefault(j, new ArrayList<Integer>()));
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}
