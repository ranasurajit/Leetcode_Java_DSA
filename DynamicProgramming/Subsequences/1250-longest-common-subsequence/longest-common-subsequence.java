class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     *
     * TC: O(M x N)
     * SC: O(N)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // Initialization
        int[] prev = new int[n + 1]; // SC: O(N)
        prev[0] = 0;
        // Iterative Calls
        for (int i = 1; i < m + 1; i++) { // TC: O(M)
            int[] current = new int[n + 1]; // SC: O(N)
            current[0] = 0;
            for (int j = 1; j < n + 1; j++) { // TC: O(N)
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(current[j - 1], prev[j]);
                }
            }
            prev = current.clone();
        }
        return prev[n];
    }

    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // Initialization
        int[][] dp = new int[m + 1][n + 1]; // SC: O(M x N)
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }
        // Iterative Calls
        for (int i = 1; i < m + 1; i++) { // TC: O(M)
            for (int j = 1; j < n + 1; j++) { // TC: O(N)
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O(M x N + (M + N))
     */
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(text1, text2, m, n, memo);
    }

    /**
     * Using Memoization
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    private int solveMemoization(String text1, String text2,
        int m, int n, int[][] memo) {
        // Base Case
        if (m == 0 || n == 0) {
            // if any String text1 or text2 exhausts we don't find anything common
            return 0;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            // we got a common character so add 1 and shrink both m and n
            return memo[m][n] = 
                1 + solveMemoization(text1, text2, m - 1, n - 1, memo);
        } else {
            /**
             * we did not get common character yet so try out
             * shrinking anyone and get the maximum out of it
             */
            return memo[m][n] = Math.max(
                solveMemoization(text1, text2, m, n - 1, memo),
                solveMemoization(text1, text2, m - 1, n, memo)
            );
        }
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     *
     * (17 / 47 testcases passed)
     */
    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return solveRecursion(text1, text2, m, n);
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    private int solveRecursion(String text1, String text2, int m, int n) {
        // Base Case
        if (m == 0 || n == 0) {
            // if any String text1 or text2 exhausts we don't find anything common
            return 0;
        }
        // Recursion Calls
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            // we got a common character so add 1 and shrink both m and n
            return 1 + solveRecursion(text1, text2, m - 1, n - 1);
        } else {
            /**
             * we did not get common character yet so try out
             * shrinking anyone and get the maximum out of it
             */
            return Math.max(
                solveRecursion(text1, text2, m, n - 1),
                solveRecursion(text1, text2, m - 1, n)
            );
        }
    }
}
