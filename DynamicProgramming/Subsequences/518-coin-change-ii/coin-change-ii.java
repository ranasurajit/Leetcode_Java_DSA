class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x T) + O(N x T) ~ O(N x T)
     * SC: O(N x T) + O(T)
     * 
     * - O(N x T) - memoization array memory
     * - O(T) - stack built up till amount becomes zero
     * 
     * Accepted (30 / 30 testcases passed)
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n + 1][amount + 1]; // SC: O(N x T)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(T)
        }
        return solveMemoization(n - 1, amount, coins, memo); // TC: O(N x T), SC: O(T)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(T)
     */
    private int solveMemoization(int idx, int amount, int[] coins, int[][] memo) {
        // Base Case
        if (idx == 0) {
            return (amount % coins[idx]) == 0 ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }
        // Recursion Calls
        int skip = solveMemoization(idx - 1, amount, coins, memo);
        int pick = 0;
        if (coins[idx] <= amount) {
            // we can pick coin at index 'idx'
            // index is at the same as we have infinite supply of a coin denomination
            pick = solveMemoization(idx, amount - coins[idx], coins, memo);
        }
        return memo[idx][amount] = pick + skip;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: O(T)
     * 
     * - O(T) - stack built up till amount becomes zero
     * 
     * Time Limit Exceeded (15 / 30 testcases passed)
     */
    public int changeRecursion(int amount, int[] coins) {
        int n = coins.length;
        return solveRecursion(n - 1, amount, coins);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: >> O(N) ~ O(T)
     */
    private int solveRecursion(int idx, int amount, int[] coins) {
        // Base Case
        if (idx == 0) {
            return (amount % coins[idx]) == 0 ? 1 : 0;
        }
        // Recursion Calls
        int skip = solveRecursion(idx - 1, amount, coins);
        int pick = 0;
        if (coins[idx] <= amount) {
            // we can pick coin at index 'idx'
            // index is at the same as we have infinite supply of a coin denomination
            pick = solveRecursion(idx, amount - coins[idx], coins);
        }
        return pick + skip;
    }
}
