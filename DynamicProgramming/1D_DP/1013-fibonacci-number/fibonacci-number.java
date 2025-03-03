class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N) ~ O(N)
     */
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveMemoization(n, memo);
    }

    private int solveMemoization(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        return memo[n] = solveMemoization(n - 1, memo) + solveMemoization(n - 2, memo);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int fibRecursion(int n) {
        return solveRecursion(n);
    }

    private int solveRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // Recursion Calls
        return solveRecursion(n - 1) + solveRecursion(n - 2);
    }
}
