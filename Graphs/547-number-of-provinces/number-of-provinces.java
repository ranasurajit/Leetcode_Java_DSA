class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                // Using BFS
                // bfsGraph(isConnected, visited, n, i);
                dfsGraph(isConnected, visited, n, i);
            }
        }
        return provinces;
    }

    private void dfsGraph(int[][] isConnected, boolean[] visited, int n, int current) {
        visited[current] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfsGraph(isConnected, visited, n, i);
            }
        }
    }

    // private void bfsGraph(int[][] isConnected, boolean[] visited, int n, int current) {
    //     Queue<Integer> queue = new LinkedList<Integer>();
    //     queue.offer(current);
    //     visited[current] = true;
    //     while (!queue.isEmpty()) {
    //         Integer node = queue.poll();
    //         for (int i = 0; i < n; i++) {
    //             if (isConnected[node][i] == 1 && !visited[i]) {
    //                 visited[i] = true;
    //                 queue.offer(i);
    //             }
    //         }
    //     }
    // }
}