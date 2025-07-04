class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x K x 2) + O(N x K x 2) ~ O(N x K)
     * SC: O(N x K x 2) + O(N) ~ O(N x K) + O(N)
     * 
     * - O(N x K x 2) - memoization memory
     * - O(N) - recursion stack
     *
     * Accepted (210 / 210 testcases passed)
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int buy = 1;
        int[][][] memo = new int[n + 1][k + 1][buy + 1]; // SC: O(N x K x 2) buy flag - 0 or 1
        for (int[][] mem : memo) { // TC: O(N)
            for (int[] m : mem) { // TC: O(K)
                Arrays.fill(m, -1); // TC: O(2)
            }
        }
        // we need to start from index 0 only as we must buy first and then only sell
        return solveMemoization(0, n, prices, k, buy, memo); // TC: O(N x K x 2), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x K x 2)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int[] prices, int k, int buy, int[][][] memo) {
        // Base Case
        if (k == 0 || idx == n) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][k][buy] != -1) {
            return memo[idx][k][buy];
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            // we can opt to buy or skip
            profit = Math.max(-1 * prices[idx] + solveMemoization(idx + 1, n, prices, k, 0, memo),
                solveMemoization(idx + 1, n, prices, k, 1, memo));
        } else {
            // we can opt to sell or skip
            profit = Math.max(prices[idx] + solveMemoization(idx + 1, n, prices, k - 1, 1, memo),
                solveMemoization(idx + 1, n, prices, k, 0, memo));
        }
        return memo[idx][k][buy] = profit;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * - O(N) - recursion stack
     *
     * Time Limit Exceeded (206 / 210 testcases passed)
     */
    public int maxProfitRecursion(int k, int[] prices) {
        int n = prices.length;
        int buy = 1;
        // we need to start from index 0 only as we must buy first and then only sell
        return solveRecursion(0, n, prices, k, buy); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, int[] prices, int k, int buy) {
        // Base Case
        if (k == 0 || idx == n) {
            return 0;
        }
        // Recursion Calls
        int profit = 0;
        if (buy == 1) {
            // we can opt to buy or skip
            profit = Math.max(-1 * prices[idx] + solveRecursion(idx + 1, n, prices, k, 0),
                solveRecursion(idx + 1, n, prices, k, 1));
        } else {
            // we can opt to sell or skip
            profit = Math.max(prices[idx] + solveRecursion(idx + 1, n, prices, k - 1, 1),
                solveRecursion(idx + 1, n, prices, k, 0));
        }
        return profit;
    }
}
