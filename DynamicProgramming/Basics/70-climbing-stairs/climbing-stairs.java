class Solution {
    public int climbStairs(int n) {
        /*
         * To reach nth step, I need to reach either (n - 1)th step or (n - 2)th step
         * From there, I will take one more step 1 or 2 steps respectively. So total
         * number of ways will dependent on number of ways I will reach (n - 1) and 
         * (n - 2) steps
         */
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}
