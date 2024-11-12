class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // return solveRecursion(m - 1, n - 1, grid);

        int[][] dp = new int[m][n];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(m - 1, n - 1, grid, dp);
    }

    /**
     * Using Memoization
     * 
     * TC: O(M x N)
     * SC: O((M - 1) + (N - 1) + (M x N))
     * 
     * @param m
     * @param n
     * @param grid
     * @return
     */
    private static int solveMemoization(int m, int n, int[][] grid, int[][] dp) {
        // Base case
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (m < 0 || n < 0) {
            return (int) 1e9;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = grid[m][n] + solveMemoization(m - 1, n, grid, dp);
        int left = grid[m][n] + solveMemoization(m, n - 1, grid, dp);
        dp[m][n] = Math.min(up, left);
        return dp[m][n];
    }

    /**
     * Using Recursion
     * 
     * TC: O(2^ (M x N))
     * SC: O((M - 1) + (N - 1))
     * 
     * @param m
     * @param n
     * @param grid
     * @return
     */
    private static int solveRecursion(int m, int n, int[][] grid) {
        // Base case
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0) {
            return (int) 1e9;
        }
        int up = grid[m][n] + solveRecursion(m - 1, n, grid);
        int left = grid[m][n] + solveRecursion(m, n - 1, grid);
        return Math.min(up, left);
    }
}
