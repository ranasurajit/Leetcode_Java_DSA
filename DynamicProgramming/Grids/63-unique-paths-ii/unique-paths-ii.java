class Solution {
    /**
     * Top-Down approach
     * TC: O(M x N)
     * SC: O(M x N) + O(M x N) ~ O(M x N)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n]; // SC: O(M x N)
        for (int[] row : dp) { // TC: O(M x N)
            Arrays.fill(row, -1);
        }
        return solve(m - 1, n - 1, dp, obstacleGrid); // TC: O(M x N) and SC: O(M x N)
    }

    private int solve(int m, int n, int[][] dp, int[][] obstacleGrid) {
        // base case
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int x = solve(m - 1, n, dp, obstacleGrid);
        int y = solve(m , n - 1, dp, obstacleGrid);
        dp[m][n] = x + y;
        return dp[m][n];
    }
}
