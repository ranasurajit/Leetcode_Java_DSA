class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        int numProvinces = 0;
        // Creating adjacency List from Matrix
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        int[] visited = new int[m];
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                // DFS call to graph
                dfsGraph(adjList, visited, i);
                numProvinces++;
            }
        }
        return numProvinces;
    }

    private void dfsGraph(List<List<Integer>> adjList, int[] visited, int current) {
        visited[current] = 1;
        for (Integer it : adjList.get(current)) {
            if (visited[it] == 0) {
                dfsGraph(adjList, visited, it);
            }
        }
    }
}
