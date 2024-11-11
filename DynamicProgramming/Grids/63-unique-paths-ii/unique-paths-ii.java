class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //  return solveRecursion(m - 1, n - 1, obstacleGrid);
        int[][] dp = new int[m][n];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(m - 1, n - 1, obstacleGrid, dp);
    }

    /**
     * Using Memoization
     * 
     * TC: O(M x N)
     * SC: O((M - 1) + (N - 1) + (M x N))
     * 
     * @param obstacleGrid
     * @return
     */
    private static int solveMemoization(int m, int n, int[][] grid, int[][] dp) {
        // Base case
        if (m >= 0 && n >= 0 && grid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = solveMemoization(m - 1, n, grid, dp);
        int left = solveMemoization(m, n - 1, grid, dp);
        dp[m][n] = up + left;
        return dp[m][n];
    }

    /**
     * Using Recursion
     * 
     * TC: O(2 ^ (M x N))
     * SC: O((M - 1) + (N - 1))
     * 
     * @param obstacleGrid
     * @return
     */
    private int solveRecursion(int m, int n, int[][] grid) {
        // Base case
        if (m >= 0 && n >= 0 && grid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        int up = solveRecursion(m - 1, n, grid);
        int left = solveRecursion(m, n - 1, grid);
        return up + left;
    }
}
