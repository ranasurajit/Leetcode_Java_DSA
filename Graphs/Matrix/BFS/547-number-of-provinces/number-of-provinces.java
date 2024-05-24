class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        int numProvinces = 0;
        int[] visited = new int[m];
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                bfsGraph(isConnected, visited, m, i);
                numProvinces++;
            }
        }
        return numProvinces;
    }

    private void bfsGraph(int[][] isConnected, int[] visited, int m, int current) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[current] = 1;
        queue.offer(current);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int i = 0; i < m; i++) {
                if (i != current && isConnected[node][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }
}
