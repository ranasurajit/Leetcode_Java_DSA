class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0) {
            dp[n] = 0;
            return dp[n];
        }
        if (n <= 2) {
            dp[n] = 1;
            return dp[n];
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}