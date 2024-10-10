class Solution {
    /**
     * Bottom-Up approach
     * TC: O(M x N)
     * SC: O(M x N) 
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // SC: O(M x N)
        dp[0][0] = 1;
        for (int[] row : dp) { // TC: O(M x N)
            Arrays.fill(row, 1);
        }
        for (int i = 1; i < m; i++) { // TC: O(M)
            for (int j = 1; j < n; j++) { // TC: O(N)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m -1][n - 1];
    }

    /**
     * Top-Down approach
     * TC: O(M x N)
     * SC: O(M x N) + O(M x N) ~ O(M x N)
     */
    public int uniquePathsRecursive(int m, int n) {
        int[][] dp = new int[m][n]; // SC: O(M x N)
        for (int[] row : dp) { // TC: O(M x N)
            Arrays.fill(row, -1);
        }
        return solveRecursively(dp, m - 1, n - 1); // TC and SC: O(M x N) 
    }

    private int solveRecursively(int[][] dp, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        /*
         * to reach grid[m - 1][n - 1] we need to count unique paths 
         * from grid[m - 1][n-2] + grid[m - 2][n - 1]
         */
        int x = solveRecursively(dp, m, n - 1);
        int y = solveRecursively(dp, m - 1, n);
        return dp[m][n] = x + y;
    }
}
