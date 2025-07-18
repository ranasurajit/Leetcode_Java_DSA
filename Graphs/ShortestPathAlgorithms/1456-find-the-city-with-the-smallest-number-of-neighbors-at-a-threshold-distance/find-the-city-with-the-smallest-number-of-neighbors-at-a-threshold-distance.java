class Solution {
    /**
     * Approach I : Using Floyd-Warshall Algorithm Approach
     *
     * TC: O(V) + O(E) + O(V ^ 3) + O(V ^ 2) + O(V) ~ O(V ^ 3)
     * SC: O(V ^ 2)
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n]; // SC: O(V x V)
        for (int i = 0; i < n; i++) {  // TC: O(V)
            Arrays.fill(graph[i], (int) 1e8);
            graph[i][i] = 0;
        }
        for (int[] edge : edges) { // TC: O(E)
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph[u][v] = wt;
            graph[v][u] = wt;
        }
        // Applying Floyd Warshall Algorithm
        for (int via = 0; via < n; via++) {   // TC: O(V)
            for (int i = 0; i < n; i++) {     // TC: O(V)
                for (int j = 0; j < n; j++) { // TC: O(V)
                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }
        int[] connections = new int[n];
        for (int i = 0; i < n; i++) {     // TC: O(V)
            for (int j = 0; j < n; j++) { // TC: O(V)
                if (i != j && graph[i][j] <= distanceThreshold) {
                    connections[i]++;
                }
            }
        }
        int minConnection = n;
        int result = -1;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (minConnection >= connections[i]) {
                minConnection = connections[i];
                result = i;
            }
        }
        return result;
    }
}
