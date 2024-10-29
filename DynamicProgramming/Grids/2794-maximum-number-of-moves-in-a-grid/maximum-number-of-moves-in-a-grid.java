class Solution {
    /**
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // SC: O(M x N)
        int result = 0;
        for (int j = n - 2; j >= 0; j--) { // TC: O(N)
            for (int i = 0; i < m; i++) {  // TC: O(M)
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j + 1]);
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
                }
                if (i < m - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
                }
                if (j == 0) {
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
