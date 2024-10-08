class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) { // TC: O(N)
            current = prev2 + prev;
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int climbStairsBetter(int n) {
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[0] = 1; // number of ways to reach 0th step (already present at 0th step)
        dp[1] = 1; // number of ways to reach 1st step
        // dp[2] = dp[0] + dp[1]; // number of ways to reach 2nd step 
        // if I am at 1st step I can take 1 step else if I am at 0th step I can take 2 steps
        for (int i = 2; i <= n; i++) { // TC: O(N)
            dp[i] = dp[i - 2] + dp[i - 1]; // number of ways to reach ith step
        }
        return dp[n];
    }
}
