class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x 2) + O(N x 2) ~ O(N x 2)
     * SC: O(N x 2) + O(N)
     * 
     * Accepted (202 / 202 testcases passed)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n + 1][2]; // buy flag - 0 or 1
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(2)
        }
        // we need to start from index 0 only as we must buy first and then only sell
        return solveMemoization(0, prices, 1, memo); // TC: O(N x 2), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int[] prices, int buy, int[][] memo) {
        // Base Case
        if (idx == prices.length) {
            // this will contribute 0 to profit
            return 0;
        }
        // Memoization Check
        if (memo[idx][buy] != -1) {
            return memo[idx][buy];
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            /**
             * we may buy the stock and set buy flag to 0 so that it 
             * will not be bought again or skip buying the stock
             */
            profit = Math.max( -1 * prices[idx] + solveMemoization(idx + 1, prices, 0, memo),
                solveMemoization(idx + 1, prices, 1, memo));
        } else {
            /**
             * we may sell the stock and set buy flag to 1 so that it 
             * will not be bought again or skip selling the stock
             */
            profit = Math.max(prices[idx] + solveMemoization(idx + 1, prices, 1, memo), 
                solveMemoization(idx + 1, prices, 0, memo));
        }
        return memo[idx][buy] = profit;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     * 
     * Time Limit Exceeded (198 / 202 testcases passed)
     */
    public int maxProfitRecursion(int[] prices) {
        int n = prices.length;
        // we need to start from index 0 only as we must buy first and then only sell
        return solveRecursion(0, prices, 1); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int[] prices, int buy) {
        // Base Case
        if (idx == prices.length) {
            // this will contribute 0 to profit
            return 0;
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            /**
             * we may buy the stock and set buy flag to 0 so that it 
             * will not be bought again or skip buying the stock
             */
            profit = Math.max( -1 * prices[idx] + solveRecursion(idx + 1, prices, 0),
                solveRecursion(idx + 1, prices, 1));
        } else {
            /**
             * we may sell the stock and set buy flag to 1 so that it 
             * will not be bought again or skip selling the stock
             */
            profit = Math.max(prices[idx] + solveRecursion(idx + 1, prices, 1), 
                solveRecursion(idx + 1, prices, 0));
        }
        return profit;
    }
}
