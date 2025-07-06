class Solution {
    /**
     * Approach I : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N x N) + O(N) ~ O(N x N)
     * SC: O(N x N)
     * 
     * - O(N x N) - dp array memory
     *
     * Accepted (47 / 47 testcases passed)
     */
    public int minInsertions(String s) {
        int n = s.length();
        String revStr = reverse(s, n); // TC: O(N)
        /**
         * this problem can be reduced to calculating length of 
         * Longest Common Subsequence (LCS) and then returning
         * n - LCS.
         * Intuition: We need to insert characters that are not
         * common between String s and reverse of String s
         */
        // Using Tabulation Approach
        // Initialization
        int[][] dp = new int[n + 1][n + 1]; // SC: O(N x N)
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 1; j < n + 1; j++) { // TC: O(N)
                if (s.charAt(i - 1) == revStr.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n];
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private String reverse(String s, int n) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = n - 1;
        while (start < end) { // TC: O(N / 2)
            char temp = ch[end];
            ch[end--] = ch[start];
            ch[start++] = temp;
        }
        return String.valueOf(ch);
    }
}
