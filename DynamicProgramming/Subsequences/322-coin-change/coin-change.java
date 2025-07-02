class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x T) + O(N x T)
     * SC: O(N x T) + O(T)
     * 
     *  - O(N x T) - memoization array memory
     *  - O(N) - recursion stack
     * 
     * Accepted (99 / 189 testcases passed)
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n + 1][amount + 1]; // SC: O(N x T)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(T)
        }
        int minCoins = solveMemoization(n - 1, coins, amount, memo); // TC: O(N x T), SC: O(T)
        return minCoins >= (int) 1e9 ? - 1 : minCoins;
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(T)
     */
    private int solveMemoization(int idx, int[] coins, int amount, int[][] memo) {
        // Base Case
        if (idx == 0) {
            if (amount > 0 && amount % coins[idx] == 0) {
                return amount / coins[idx];
            } else if (amount == 0) {
                return 0;
            }
            return (int) 1e9;
        }
        // Memoization Check
        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }
        // Recursion Calls
        int skip = solveMemoization(idx - 1, coins, amount, memo);
        int pick = (int) 1e9;
        if (coins[idx] <= amount) {
            // 1 coin picked
            pick = 1 + solveMemoization(idx, coins, amount - coins[idx], memo);
        }
        return memo[idx][amount] = Math.min(pick, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: >> O(N) ~ O(T)
     * 
     *  - O(N) - recursion stack
     * 
     * Time Limit Exceeded (99 / 189 testcases passed)
     */
    public int coinChangeRecursion(int[] coins, int amount) {
        int n = coins.length;
        int minCoins = solveRecursion(n - 1, coins, amount);
        return minCoins >= (int) 1e9 ? - 1 : minCoins;
    }

    /**
     * Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: >> O(N) ~ O(T)
     */
    private int solveRecursion(int idx, int[] coins, int amount) {
        // Base Case
        if (idx == 0) {
            if (amount > 0 && amount % coins[idx] == 0) {
                return amount / coins[idx];
            } else if (amount == 0) {
                return 0;
            }
            return (int) 1e9;
        }
        // Recursion Calls
        int skip = solveRecursion(idx - 1, coins, amount);
        int pick = (int) 1e9;
        if (coins[idx] <= amount) {
            // 1 coin picked
            pick = 1 + solveRecursion(idx, coins, amount - coins[idx]);
        }
        return Math.min(pick, skip);
    }
}
