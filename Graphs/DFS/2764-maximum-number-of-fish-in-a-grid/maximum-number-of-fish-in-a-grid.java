class Solution {
    /**
     * Using DFS Approach
     *
     * TC: O(2 x M x N) ~ O(M x N)
     * SC: O(M x N)
     */
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;
        for (int i = 0; i < m; i++) {     // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (!visited[i][j] && grid[i][j] > 0) {
                    int[] fishes = { 0 };
                    dfsGraph(i, j, grid, visited, fishes, m, n); // TC: O(M x N)
                    maxFish = Math.max(maxFish, fishes[0]);
                }
            }
        }
        return maxFish;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    private void dfsGraph(int row, int col, int[][] grid, boolean[][] visited,
        int[] fishes, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] ||
            grid[row][col] == 0) {
            return;
        }
        fishes[0] += grid[row][col];
        visited[row][col] = true;
        // navigate to all 4 directions
        dfsGraph(row, col + 1, grid, visited, fishes, m, n); // right
        dfsGraph(row, col - 1, grid, visited, fishes, m, n); // left
        dfsGraph(row + 1, col, grid, visited, fishes, m, n); // down
        dfsGraph(row - 1, col, grid, visited, fishes, m, n); // up
    }
}
