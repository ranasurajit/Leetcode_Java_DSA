class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsGraph(stones, visited, i);
                groups++;
            }
        }
        return n - groups;
    }

    private void dfsGraph(int[][] stones, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < stones.length; i++) {
            int row = stones[index][0];
            int col = stones[index][1];
            if (!visited[i] && (stones[i][0] == row || stones[i][1] == col)) {
                dfsGraph(stones, visited, i);
            }
        }
    }
}
