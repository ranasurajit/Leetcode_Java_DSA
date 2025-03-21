class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N + N) ~ O(2 x N)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n + 1][2]; // SC: O(2 x N)
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
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
