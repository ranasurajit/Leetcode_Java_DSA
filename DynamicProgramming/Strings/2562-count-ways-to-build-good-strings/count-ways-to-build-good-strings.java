class Solution {
    private int MOD = 1000000007;

    /**
     * Using Tabulation
     *
     * TC: O(High)
     * SC: O(High + Max(Zero, One))
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int maxLength = high + Math.max(zero, one);
        int[] dp = new int[maxLength + 1];
        for (int currentLength = high; currentLength >= 0; currentLength--) {
            int zeroLen = zero + currentLength;
            int oneLen = one + currentLength;
            int zeroCount = zeroLen >= low && zeroLen <= high ? 1 : 0;
            int oneCount = oneLen >= low && oneLen <= high ? 1 : 0;
            int result = (zeroCount + dp[zeroLen] + oneCount + dp[oneLen]) % MOD;
            dp[currentLength] = result;
        }
        return dp[0];
    }

    /**
     * Using Memoization
     *
     * TC: O(2 x High)
     * SC: O(High + Max(Zero, One))
     */
    public int countGoodStringsMemoization(int low, int high, int zero, int one) {
        int maxLength = high + Math.max(zero, one);
        int[] dp = new int[maxLength + 1];
        Arrays.fill(dp, -1);
        return solve(low, high, zero, one, 0, dp);
    }

    private int solve(int low, int high, int zero, int one, int currentLength, int[] dp) {
        // base case
        if (currentLength > high) {
            return 0;
        }
        if (dp[currentLength] != -1) {
            return dp[currentLength];
        }
        int zeroLen = zero + currentLength;
        int oneLen = one + currentLength;
        int zeroCount = zeroLen >= low && zeroLen <= high ? 1 : 0;
        int oneCount = oneLen >= low && oneLen <= high ? 1 : 0;
        int result = (zeroCount + solve(low, high, zero, one, zeroLen, dp) +
                     oneCount + solve(low, high, zero, one, oneLen, dp)) % MOD;
        dp[currentLength] = result;
        return dp[currentLength];
    }
}
