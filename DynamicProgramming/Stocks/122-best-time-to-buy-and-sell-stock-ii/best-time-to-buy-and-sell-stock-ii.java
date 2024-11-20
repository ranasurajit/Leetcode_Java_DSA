class Solution {
    /**
     * Using Tabulation
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        /*
         * buy param is 1 to buy and 0 to sell, so in index = 0,
         * we can only buy so buy = 1
         */
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0; // Base case
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;
                if (buy == 1) {
                    // Max(if I decide to buy or not buy on day at index i)
                    profit = Math.max(-1 * prices[idx] + dp[idx + 1][0],
                            0 + dp[idx + 1][1]);
                } else {
                    // Max(if I decide to sell or not sell on day at index i)
                    profit = Math.max(prices[idx] + dp[idx + 1][1],
                            0 + dp[idx + 1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }

    /**
     * Using Memoization
     * 
     * TC: O(N x 2) ~ O(N)
     * SC: O(N x 2) + O(N) ~ O(N x 3) ~ O(N)
     * 
     * @param prices
     * @return
     */
    public int maxProfitMemoization(int[] prices) {
        /*
         * buy param is 1 to buy and 0 to sell, so in index = 0,
         * we can only buy so buy = 1
         */
        // states are index and (buy/sell i.e. 1 or 0)
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(0, 1, prices, dp);
    }

    private static int solveMemoization(int i, int buy, int[] prices, int[][] dp) {
        // Base case
        if (i == prices.length) {
            // canot make profit on day at index = n (prices.length)
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        int profit = 0;
        if (buy == 1) {
            // Max(if I decide to buy or not buy on day at index i)
            profit = Math.max(-1 * prices[i] + solveMemoization(i + 1, 0, prices, dp),
                    0 + solveMemoization(i + 1, 1, prices, dp));
        } else {
            // Max(if I decide to sell or not sell on day at index i)
            profit = Math.max(prices[i] + solveMemoization(i + 1, 1, prices, dp),
                    0 + solveMemoization(i + 1, 0, prices, dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }

    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     * 
     * @param prices
     * @return
     */
    public int maxProfitUsingRecursion(int[] prices) {
        /*
         * buy param is 1 to buy and 0 to sell, so in index = 0,
         * we can only buy so buy = 1
         */
        return solveRecursion(0, 1, prices);
    }

    private static int solveRecursion(int i, int buy, int[] prices) {
        // Base case
        if (i == prices.length) {
            // canot make profit on day at index = n (prices.length)
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            // Max(if I decide to buy or not buy on day at index i)
            profit = Math.max(-1 * prices[i] + solveRecursion(i + 1, 0, prices),
                    0 + solveRecursion(i + 1, 1, prices));
        } else {
            // Max(if I decide to sell or not sell on day at index i)
            profit = Math.max(prices[i] + solveRecursion(i + 1, 1, prices),
                    0 + solveRecursion(i + 1, 0, prices));
        }
        return profit;
    }
}
