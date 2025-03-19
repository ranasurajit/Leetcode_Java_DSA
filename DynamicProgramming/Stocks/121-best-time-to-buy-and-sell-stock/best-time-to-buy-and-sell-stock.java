class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(4 x  N)
     * SC: O(N + N)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n + 1][2][2]; // SC: O(4 x N) ~ O(N)
        for (int[][] memoItem : memo) {
            for (int[] mem : memoItem) {
                Arrays.fill(mem, -1);
            }
        }
        return solveMemoization(0, n, prices, 1, 1, memo);
    }

    /**
     * Using Memoization
     *
     * TC: O(4 x N)
     * SC: O(N)
     */
    private int solveMemoization(int index, int n, int[] prices,
        int buy, int k, int[][][] memo) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[index][buy][k] != -1) {
            return memo[index][buy][k];
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            // we have two options to buy or not to buy
            // pick
            pick = (-1 * prices[index]) + solveMemoization(index + 1, n, prices, 0, k, memo);
            // not pick
            notpick = solveMemoization(index + 1, n, prices, 1, k, memo);
        } else {
            // we have two options to sell or not to sell
            // pick
            pick = prices[index] + solveMemoization(index + 1, n, prices, 0, k - 1, memo);
            // not pick
            notpick = solveMemoization(index + 1, n, prices, 0, k, memo);
        }
        return memo[index][buy][k] = Math.max(pick, notpick);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int maxProfitRecursion(int[] prices) {
        int n = prices.length;
        return solveRecursion(0, n, prices, true, 1);
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int index, int n, int[] prices, boolean buy, int k) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy) {
            // we have two options to buy or not to buy
            // pick
            pick = (-1 * prices[index]) + solveRecursion(index + 1, n, prices, false, k);
            // not pick
            notpick = solveRecursion(index + 1, n, prices, true, k);
        } else {
            // we have two options to sell or not to sell
            // pick
            pick = prices[index] + solveRecursion(index + 1, n, prices, false, k - 1);
            // not pick
            notpick = solveRecursion(index + 1, n, prices, false, k);
        }
        return Math.max(pick, notpick);
    }
}
