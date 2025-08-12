class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N x N)
     * SC: O(N x N) + O(N)
     *
     * - O(N x N) - memoization memory
     * - O(N) - recursion stack
     *
     * Accepted (1502 / 1502 testcases passed)
     */
    public int numberOfWays(int n, int x) {
        // states / parameters changing are start and sum 
        int[][] memo = new int[n + 1][n + 1]; // SC: O(N x N)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(1, n, x, n, memo); // TC: O(N x N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     */
    private int solveMemoization(int start, int sum, int x, int n, int[][] memo) {
        // Base Case
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if ((int) Math.pow(start, x) > n) {
            return 0;
        }
        // Memoization Check
        if (memo[start][sum] != -1) {
            return memo[start][sum];
        }
        // Recursion Calls
        // we can pick to add a number start (if <= n) to the sum or skip
        // pick
        int pick = 0;
        int skip = 0;
        if (sum - (int) Math.pow(start, x) >= 0) {
            // pick
            pick = solveMemoization(start + 1, sum - (int) Math.pow(start, x), x, n, memo) % MOD;
            // skip
            skip = solveMemoization(start + 1, sum, x, n, memo) % MOD;
        } else {
            // skip
            skip = solveMemoization(start + 1, sum, x, n, memo) % MOD;
        }
        return memo[start][sum] = (pick + skip) % MOD;
    }

    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (352 / 1502 testcases passed)
     */
    public int numberOfWaysRecursion(int n, int x) {
        return solveRecursion(1, n, x, n); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int start, int sum, int x, int n) {
        // Base Case
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if ((int) Math.pow(start, x) > n) {
            return 0;
        }
        // Recursion Calls
        // we can pick to add a number start (if <= n) to the sum or skip
        // pick
        int pick = 0;
        int skip = 0;
        if (sum - (int) Math.pow(start, x) >= 0) {
            // pick
            pick = solveRecursion(start + 1, sum - (int) Math.pow(start, x), x, n);
            // skip
            skip = solveRecursion(start + 1, sum, x, n);
        } else {
            // skip
            skip = solveRecursion(start + 1, sum, x, n);
        }
        return pick + skip;
    }
}
