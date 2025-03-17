class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     *
     * (17 / 47 testcases passed)
     */
    public int longestCommonSubsequence(String text1, String text2) {
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
