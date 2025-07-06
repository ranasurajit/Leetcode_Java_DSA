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
     * Accepted (1147 / 1147 testcases passed)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n]; // SC: O(M x N)
        for (int[] mem : memo) { // TC: O(M)
            Arrays.fill(mem, -1); // TC: O(N)
        }
        return solveMemoization(word1, word2, m - 1, n - 1, memo); // TC: O(M x N), SC: O(M + N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O(M + N)
     */
    private int solveMemoization(String word1, String word2, int m, int n, int[][] memo) {
        // Base Case
        if (m < 0) {
            /**
             * we have exhaused all Characters from word1 so we need
             * add remaining Characters from word2 from 0 to n index
             */
            return n + 1;
        }
        if (n < 0) {
            /**
             * we have exhaused all Characters from word2 so we need
             * delete remaining Characters from word1 from 0 to m index
             */
            return m + 1;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        if (word1.charAt(m) == word2.charAt(n)) {
            // as the Characters match, so no need to perform any operation
            return memo[m][n] = solveMemoization(word1, word2, m - 1, n - 1, memo);
        }
        // here the Characters do not match at index n1 and n2
        int insertOperations = 1 + solveMemoization(word1, word2, m, n - 1, memo);
        int deleteOperations = 1 + solveMemoization(word1, word2, m - 1, n, memo);
        int replaceOperations = 1 + solveMemoization(word1, word2, m - 1, n - 1, memo);
        return memo[m][n] = Math.min(insertOperations, Math.min(deleteOperations, replaceOperations));
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ Max(M, N))
     * SC: O(M + N)
     *
     * - O(M + N) - recursion stack
     *
     * Time Limit Exceeded (26 / 1147 testcases passed)
     */
    public int minDistanceRecursion(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return solveRecursion(word1, word2, m - 1, n - 1);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ Max(M, N))
     * SC: O(M + N)
     */
    private int solveRecursion(String word1, String word2, int m, int n) {
        // Base Case
        if (m < 0) {
            /**
             * we have exhaused all Characters from word1 so we need
             * add remaining Characters from word2 from 0 to n index
             */
            return n + 1;
        }
        if (n < 0) {
            /**
             * we have exhaused all Characters from word2 so we need
             * delete remaining Characters from word1 from 0 to m index
             */
            return m + 1;
        }
        // Recursion Calls
        if (word1.charAt(m) == word2.charAt(n)) {
            // as the Characters match, so no need to perform any operation
            return solveRecursion(word1, word2, m - 1, n - 1);
        }
        // here the Characters do not match at index n1 and n2
        int insertOperations = 1 + solveRecursion(word1, word2, m, n - 1);
        int deleteOperations = 1 + solveRecursion(word1, word2, m - 1, n);
        int replaceOperations = 1 + solveRecursion(word1, word2, m - 1, n - 1);
        return Math.min(insertOperations, Math.min(deleteOperations, replaceOperations));
    }
}
