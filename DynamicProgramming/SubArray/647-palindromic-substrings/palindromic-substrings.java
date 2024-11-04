class Solution {
    /**
     * TC: O(N x N + 2 x N) ~ O(N x N)
     * // SC: O(2 x N x N)  ~ O(N x N)
     */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];                          // SC: O(N x N)
        int[][] dpCount = new int[n][n];                             // SC: O(N x N)
        // count palindrome substrings of length 1
        for (int i = 0; i < n; i++) {                                // TC: O(N)
            dp[i][i] = true;
            dpCount[i][i] = 1;
        }
        // count palindrome substrings of length 2
        for (int i = 0; i < n - 1; i++) {                            // TC: O(N)
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
            dpCount[i][i + 1] = dpCount[i][i] + 
                                dpCount[i + 1][i + 1] + 
                                (dp[i][i + 1] ? 1 : 0);
        }
        // count palindrome substrings of length 3 and above till n
        for (int length = 3; length <= n; length++) {               // TC: O(N)
            for (int i = 0; i <= n - length; i++) {                 // TC: O(N)
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                dpCount[i][j] = dpCount[i + 1][j] + dpCount[i][j - 1] - 
                                dpCount[i + 1][j - 1] + (dp[i][j] ? 1 : 0);
            }
        }
        return dpCount[0][n - 1];
    }
}
