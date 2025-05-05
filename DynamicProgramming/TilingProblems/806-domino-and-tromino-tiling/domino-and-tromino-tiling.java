class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Approach II: Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N)
     *
     * Accepted (39 / 39 testcases passed)
     */
    public int numTilings(int n) {
        int[] memo = new int[n + 1]; // SC: O(N)
        Arrays.fill(memo, -1);
        return solveMemoization(n, memo) % MOD;
    }

    /**
     * Using Memoization
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] memo) {
        // Base Case
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        return memo[n] = ((2 * solveMemoization(n - 1, memo)) % MOD + 
            (solveMemoization(n - 3, memo) % MOD)) % MOD;
    }

    /**
     * Approach I: Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (14 / 39 testcases passed)
     */
    public int numTilingsRecursion(int n) {
        return solveRecursion(n) % MOD;
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n) {
        // Base Case
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }
        // Recursion Calls
        return ((2 * solveRecursion(n - 1)) % MOD + (solveRecursion(n - 3) % MOD)) % MOD;
    }
}
