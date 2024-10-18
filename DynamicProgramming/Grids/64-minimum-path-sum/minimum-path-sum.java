class Solution {
    /**
     * TC: O((M x N) + (M + N)) ~ O(M x N)
     * SC: O(M x N)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // SC: O(M x N)
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) { // TC: O(M)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) { // TC: O(N)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) { // TC: O(M)
            for (int j = 1; j < n; j++) { // TC: O(N)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
