class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Approach III : Using Recursion + Memoization + Combinatorics Approach
     *
     * TC: O(N x M x log(M))
     * SC: O(N + M)
     *
     * where M = maxValue
     *
     * Accepted (38 / 47 testcases passed)
     */
    public int idealArrays(int n, int maxValue) {
        /**
         * minimum multiplication factor is 2 and 
         * till 10^4 we can get maximum 14 combinations as
         * 2^13 = 8192 and 2^14 = 16284 (> 10^4) so we have
         * combinations 0 to 13 = 14
         */
        int[][] dp = new int[15][maxValue + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int[][] memo = new int[n + 1][15]; // For combinations (nCk)
        long result = 0L;
        for (int i = 1; i <= maxValue; i++) {
            result = (result + helperMemoCombinatorics(n, maxValue, 1, i, dp, memo)) % MOD;
        }
        return (int) result % MOD;
    }

    private int Comb(int n, int k, int[][] memo) {
        if (k == 0) return 1;
        if (n == 0) return 0;

        if (memo[n][k] != 0) return memo[n][k];

        memo[n][k] = (Comb(n - 1, k, memo) + Comb(n - 1, k - 1, memo)) % MOD;
        return memo[n][k];
    }

    private int helperMemoCombinatorics(int n, int maxValue, int index, 
        int val, int[][] dp, int[][] memo) {
        if (index == n) return 1;
        if (dp[index][val] != -1) return dp[index][val];

        long ans = 0;
        long j = 2;
        boolean flag = false;

        while ((long) val * j <= maxValue) {
            ans = (ans + 
                helperMemoCombinatorics(n, maxValue, 
                index + 1, (int) (val * j), dp, memo)) % MOD;
            j++;
            if ((long) val * j > maxValue) {
                ans = (ans + Comb(n - 1, index - 1, memo)) % MOD;
            }
            flag = true;
        }
        if (!flag) {
            if ((long) val * j > maxValue) {
                ans = (ans + Comb(n - 1, index - 1, memo)) % MOD;
            }
        }
        return dp[index][val] = (int) (ans % MOD);
    }

    /**
     * Approach II : Using Recursion + Memoization Approach
     *
     * TC: O(N x M x log(M))
     * SC: O(N x M)
     *
     * where M = maxValue
     *
     * Time Limit Exceeded (38 / 47 testcases passed)
     */
    public int idealArraysMemoization(int n, int maxValue) {
        long result = 0L;
        long[][] memo = new long[n + 1][maxValue + 1];
        for (long[] mem : memo) {
            Arrays.fill(mem, -1L);
        }
        for (int i = 1; i <= maxValue; i++) {
            result = (result + helperMemoization(i, 1, maxValue, n, memo)) % MOD;
        }
        return (int) result % MOD;
    }

    private long helperMemoization(int value, int index, int maxValue, int n, long[][] memo) {
        if (index == n) {
            return 1L;
        }
        long j = 1L;
        if (memo[index][value] != -1) {
            return memo[index][value];
        }
        long result = 0L;
        while ((long) value * j <= maxValue) {
            result = (result + 
                helperMemoization((int) (value * j), index + 1, maxValue, n, memo)) % MOD;
            j++;
        }
        return memo[index][value] = result % MOD;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(M x B ^ N)
     * SC: O(N)
     *
     * where M = maxValue and B = number of branches
     *
     * Time Limit Exceeded (31 / 47 testcases passed)
     */
    public int idealArraysRecursion(int n, int maxValue) {
        long result = 0L;
        for (int i = 1; i <= maxValue; i++) {
            result += helper(i, 1, maxValue, n);
        }
        return (int) result;
    }

    private long helper(int value, int index, int maxValue, int n) {
        if (index == n) {
            return 1L;
        }
        long j = 1L;
        long result = 0L;
        while ((long) value * j <= maxValue) {
            result += helper((int) (value * j), index + 1, maxValue, n);
            j++;
        }
        return result;
    }
}
