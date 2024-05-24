class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        int numProvinces = 0;
        int[] visited = new int[m];
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                dfsGraph(isConnected, visited, m, i);
                numProvinces++;
            }
        }
        return numProvinces;
    }

    private void dfsGraph(int[][] isConnected, int[] visited, int m, int current) {
        visited[current] = 1;
        for (int i = 0; i < m; i++) {
            if (i != current && isConnected[current][i] == 1 && visited[i] == 0) {
                dfsGraph(isConnected, visited, m, i);
            }
        }
    }
}
