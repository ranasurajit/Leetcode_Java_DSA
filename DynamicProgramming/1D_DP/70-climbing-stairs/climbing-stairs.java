class Solution {
    /**
     * Approach IV : Using Space Optimization
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int climbStairs(int n) {
        // Initialization
        int prev2 = 1;
        int prev = 1;
        /**
         * Iterative Call
         * replace
         * dp[i] with current
         * dp[i - 1] with prev
         * dp[i - 2] with prev2
         */
        for (int i = 2; i < n + 1; i++) { // TC: O(N)
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    /**
     * Approach III : Using Tabulation
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int climbStairsTabulation(int n) {
        // Initialization
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[0] = 1;
        dp[1] = 1;
        // Iterative Call
        for (int i = 2; i < n + 1; i++) { // TC: O(N)
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Approach II : Using Memoization
     *
     * TC: O(N)
     * SC: O(N + N) ~ O(N)
     */
    public int climbStairsMemoization(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveMemoization(n, memo);
    }

    /*
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] memo) {
        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        int xWays = solveMemoization(n - 1, memo);
        int yWays = solveMemoization(n - 2, memo);
        return memo[n] = xWays + yWays;
    }

    /**
     * Approach I : Using Recursion
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int climbStairsRecursion(int n) {
        return solveRecursion(n);
    }

    /*
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n) {
        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursion Calls
        int xWays = solveRecursion(n - 1);
        int yWays = solveRecursion(n - 2);
        return xWays + yWays;
    }
}
