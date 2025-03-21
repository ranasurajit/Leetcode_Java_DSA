class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(6 x N) ~ O(N)
     * SC: O(6 x N + N) ~ O(N + N)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        // buy = 1 then you can buy else you can sell
        int[][][] memo = new int[n + 1][2][3]; // SC: O(6 x N)
        for (int[][] memoItem : memo) {
            for (int[] mem : memoItem) {
                Arrays.fill(mem, -1);
            }
        }
        return solveMemoization(0, n, prices, 1, k, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(6 x N) ~ O(N)
     * SC: O(6 x N) ~ O(N)
     */
    private int solveMemoization(int index, int n, int[] prices,
        int buy, int k, int[][][] memo) {
        // Base Case
        if (index == n) {
            return 0;
        }
        if (k == 0) {
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
            // buy
            pick = -1 * prices[index] + solveMemoization(index + 1, n, prices, 0, k, memo);
            notpick = solveMemoization(index + 1, n, prices, 1, k, memo);
        } else {
            // sell
            pick = prices[index] + solveMemoization(index + 1, n, prices, 1, k - 1, memo);
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
        int k = 2;
        // buy = 1 then you can buy else you can sell
        return solveRecursion(0, n, prices, 1, k);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int index, int n, int[] prices, int buy, int k) {
        // Base Case
        if (index == n) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            // buy
            pick = -1 * prices[index] + solveRecursion(index + 1, n, prices, 0, k);
            notpick = solveRecursion(index + 1, n, prices, 1, k);
        } else {
            // sell
            pick = prices[index] + solveRecursion(index + 1, n, prices, 1, k - 1);
            notpick = solveRecursion(index + 1, n, prices, 0, k);
        }
        return Math.max(pick, notpick);
    }
}
