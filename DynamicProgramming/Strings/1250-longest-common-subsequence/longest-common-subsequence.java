class Solution {
    /**
     * Approach II : Using Memoization
     *
     * TC: O(M x N)
     * SC: O((M x N) + (M + N))
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

    private int solveMemoization(String text1, String text2,
        int m, int n, int[][] memo) {
        // Base case
        if (m == 0 || n == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursive Calls
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return memo[m][n] = 
                1 + solveMemoization(text1, text2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = 
                Math.max(solveMemoization(text1, text2, m - 1, n, memo),
                         solveMemoization(text1, text2, m, n - 1, memo));
        }
    }

    /**
     * Approach I : Using Recursion
     *
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return solveRecursion(text1, text2, m, n);
    }

    private int solveRecursion(String text1, String text2, int m, int n) {
        // Base case
        if (m == 0 || n == 0) {
            return 0;
        }
        // Recursive Calls
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + solveRecursion(text1, text2, m - 1, n - 1);
        } else {
            return Math.max(solveRecursion(text1, text2, m - 1, n),
                            solveRecursion(text1, text2, m, n - 1));
        }
    }
}
