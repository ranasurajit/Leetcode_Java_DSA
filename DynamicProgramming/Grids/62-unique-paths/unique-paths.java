class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, - 1);
        }
        return helper(m - 1, n - 1, dp);
    }

    private int helper(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int xways = helper(m - 1, n, dp); // no of ways to reach [m - 2, n - 1]th cell
        int yways = helper(m, n - 1, dp); // no of ways to reach [m - 1, n - 2]th cell
        dp[m][n] = xways + yways;
        return dp[m][n];
    }
}
