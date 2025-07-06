class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(M x N) + O(M x N) ~ O(M x N)
     * SC: O(M x N) + O(M + N)
     * 
     * - O(M x N) - memoization memory
     * - O(M + N) - recursion stack
     *
     * Accepted (66 / 66 testcases passed)
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m + 1][n + 1]; // SC: O(M x N)
        for (int[] mem : memo) {  // TC: O(M)
            Arrays.fill(mem, -1); // TC: O(N)
        }
        return solveMemoization(s, t, m - 1, n - 1, memo); // TC: O(M x N), SC: O(M + N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O(M + N)
     */
    private int solveMemoization(String s, String t, int m, int n, int[][] memo) {
        // Base Case
        if (n < 0) {
            // we found a way /distinct subsequence
            return 1;
        }
        if (m < 0) {
            // we are exhaused with String s so we return 0 as n != 0
            return 0;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        if (s.charAt(m) == t.charAt(n)) {
            /**
             * we can either take or not take the Character at index m
             * If we take, then we reduce indices from both, 
             * else we reduce index of String s only
             */
            return memo[m][n] = solveMemoization(s, t, m - 1, n - 1, memo) + 
                solveMemoization(s, t, m - 1, n, memo);
        } else {
            return memo[m][n] = solveMemoization(s, t, m - 1, n, memo);
        }
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     *
     * - O(M + N) - recursion stack
     *
     * Time Limit Exceeded (55 / 66 testcases passed)
     */
    public int numDistinctRecursion(String s, String t) {
        int m = s.length();
        int n = t.length();
        return solveRecursion(s, t, m - 1, n - 1); // TC: O(2 ^ (M + N)), SC: O(M + N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    private int solveRecursion(String s, String t, int m, int n) {
        // Base Case
        if (n < 0) {
            // we found a way /distinct subsequence
            return 1;
        }
        if (m < 0) {
            // we are exhaused with String s so we return 0 as n != 0
            return 0;
        }
        // Recursion Calls
        if (s.charAt(m) == t.charAt(n)) {
            /**
             * we can either take or not take the Character at index m
             * If we take, then we reduce indices from both, 
             * else we reduce index of String s only
             */
            return solveRecursion(s, t, m - 1, n - 1) + solveRecursion(s, t, m - 1, n);
        } else {
            return solveRecursion(s, t, m - 1, n);
        }
    }
}
