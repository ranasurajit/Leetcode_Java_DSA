class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[2]; // SC: O(2) ~ O(1)
        // buy = 1 = you can buy else you can sell
        // Initialization - if (index == n) return 0
        next[0] = 0;
        next[1] = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            int[] current = new int[2];
            for (int buy = 0; buy < 2; buy++) { // TC: O(2)
                if (buy == 1) {
                    // buy
                    current[buy] = Math.max(next[1], -1 * prices[i] + next[0]);
                } else {
                    // sell
                    current[buy] = Math.max(next[0], prices[i] + next[1]);
                }
                next = current.clone();
            }
        }
        return next[1];
    }

    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // SC: O(2 x N)
        // buy = 1 = you can buy else you can sell
        // Initialization - if (index == n) return 0
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            for (int buy = 0; buy < 2; buy++) { // TC: O(2)
                if (buy == 1) {
                    // buy
                    dp[i][buy] = Math.max(dp[i + 1][1], -1 * prices[i] + dp[i + 1][0]);
                } else {
                    // sell
                    dp[i][buy] = Math.max(dp[i + 1][0], prices[i] + dp[i + 1][1]);
                }
            }
        }
        return dp[0][1];
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N + N) ~ O(2 x N)
     */
    public int maxProfitMemoization(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n + 1][2]; // SC: O(2 x N)
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        // buy = 1 = you can buy else you can sell
        return solveMemoization(0, n, prices, 1, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    private int solveMemoization(int index, int n, int[] prices, int buy, int[][] memo) {
        // Base Case
        if (index == n) {
            return 0;
        }
        // Memoization Check
        if (memo[index][buy] != -1) {
            return memo[index][buy];
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            // buy
            pick = -1 * prices[index] + solveMemoization(index + 1, n, prices, 0, memo);
            notpick = solveMemoization(index + 1, n, prices, 1, memo);
        } else {
            // sell
            pick = prices[index] + solveMemoization(index + 1, n, prices, 1, memo);
            notpick = solveMemoization(index + 1, n, prices, 0, memo);
        }
        return memo[index][buy] = Math.max(pick, notpick);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int maxProfitRecursion(int[] prices) {
        int n = prices.length;
        // buy = 1 = you can buy else you can sell
        return solveRecursion(0, n, prices, 1);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int index, int n, int[] prices, int buy) {
        // Base Case
        if (index == n) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            // buy
            pick = -1 * prices[index] + solveRecursion(index + 1, n, prices, 0);
            notpick = solveRecursion(index + 1, n, prices, 1);
        } else {
            // sell
            pick = prices[index] + solveRecursion(index + 1, n, prices, 1);
            notpick = solveRecursion(index + 1, n, prices, 0);
        }
        return Math.max(pick, notpick);
    }
}
