class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int p = 0; // pointer at factor 2
        int q = 0; // pointer at factor 3
        int r = 0; // pointer at factor 5

        dp[0] = 1; // 1st ugly number
        for (int i = 1; i < n; i++) {
            int mult2 = 2 * dp[p];
            int mult3 = 3 * dp[q];
            int mult5 = 5 * dp[r];

            dp[i] = Math.min(mult2, Math.min(mult3, mult5));
            // move the pointers when it is same as dp[i]
            if (dp[i] == mult2) {
                p++;
            }
            if (dp[i] == mult3) {
                q++;
            }
            if (dp[i] == mult5) {
                r++;
            }
        }
        return dp[n - 1];
    }
}
