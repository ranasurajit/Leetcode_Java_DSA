class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // fill dp array for 0th index column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        // fill dp array for 0th index row
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        // fill dp array with min sum which comes from top and left (for down and right movement)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = dp[i - 1][j]; // from top
                int y = dp[i][j - 1]; // from left
                dp[i][j] = grid[i][j] + Math.min(x, y);
            }
        }
        // return the min sum accumulated at bottom-right most cell
        return dp[m - 1][n - 1];
    }
}
