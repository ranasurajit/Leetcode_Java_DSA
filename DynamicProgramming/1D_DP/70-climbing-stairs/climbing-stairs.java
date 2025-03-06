class Solution {
    /**
     * Approach II : Using Memoization
     *
     * TC: O(N)
     * SC: O(N + N) ~ O(N)
     */
    public int climbStairs(int n) {
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
        if (n == 0 || n == 1 || n == 2) {
            return n;
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
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        // Recursion Calls
        int xWays = solveRecursion(n - 1);
        int yWays = solveRecursion(n - 2);
        return xWays + yWays;
    }
}
