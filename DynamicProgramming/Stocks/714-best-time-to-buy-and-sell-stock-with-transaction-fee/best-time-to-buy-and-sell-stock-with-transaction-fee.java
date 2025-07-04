class Solution {
    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N x 2)
     * SC: O(N x 2)
     * 
     * - O(N x 2) - dp array memory
     *
     * Accepted (44 / 44 testcases passed)
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = 1;
        int[][] dp = new int[n + 1][buy + 1]; // SC: O(N x 2) buy flag - 0 or 1
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            for (int j = 0; j < 2; j++) { // TC: O(2)
                if (j == 1) {
                    // buy
                    dp[i][j] = Math.max(-1 * prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    // sell - transaction is counted here
                    dp[i][j] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x 2) + O(N x 2) ~ O(N x 2)
     * SC: O(N x 2) + O(N)
     * 
     * - O(N x 2) - memoization memory
     * - O(N) - recursion stack
     *
     * Accepted (44 / 44 testcases passed)
     */
    public int maxProfitMemoization(int[] prices, int fee) {
        int n = prices.length;
        int buy = 1;
        int[][] memo = new int[n + 1][buy + 1]; // SC: O(N x 2) buy flag - 0 or 1
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(2)
        }
        // we need to start from index 0 only as we must buy first and then only sell
        return solveMemoization(0, n, prices, buy, fee, memo); // TC: O(N x 2), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x 2)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int[] prices, int buy, int fee, int[][] memo) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][buy] != -1) {
            return memo[idx][buy];
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            // we can opt to buy or skip
            profit = Math.max(-1 * prices[idx] + solveMemoization(idx + 1, n, prices, 0, fee, memo),
                solveMemoization(idx + 1, n, prices, 1, fee, memo));
        } else {
            // we can opt to sell or skip
            profit = Math.max(prices[idx] - fee + solveMemoization(idx + 1, n, prices, 1, fee, memo),
                solveMemoization(idx + 1, n, prices, 0, fee, memo));
        }
        return memo[idx][buy] = profit;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * - O(N) - recursion stack
     *
     * Time Limit Exceeded (19 / 44 testcases passed)
     */
    public int maxProfitRecursion(int[] prices, int fee) {
        int n = prices.length;
        int buy = 1;
        // we need to start from index 0 only as we must buy first and then only sell
        return solveRecursion(0, n, prices, buy, fee); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, int[] prices, int buy, int fee) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            // we can opt to buy or skip
            profit = Math.max(-1 * prices[idx] + solveRecursion(idx + 1, n, prices, 0, fee),
                solveRecursion(idx + 1, n, prices, 1, fee));
        } else {
            // we can opt to sell or skip
            profit = Math.max(prices[idx] - fee + solveRecursion(idx + 1, n, prices, 1, fee),
                solveRecursion(idx + 1, n, prices, 0, fee));
        }
        return profit;
    }
}
