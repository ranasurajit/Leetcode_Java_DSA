class Solution {
    /**
     * TC: O(N x N + N) ~ O(N x N)
     * SC: O(N x N)
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];                      // SC: O(N x N)

        String result = "";
        // palindrome substring of length 1
        for (int i = 0; i < n; i++) {                            // TC: O(N)
            dp[i][i] = true;
            result = s.charAt(i) + "";
        }
        // palindrome substring of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
            if (dp[i][i + 1]) {
                result = s.substring(i, i + 2);
            }
        }
        // palindrome substring of length 3 and above till length n
        for (int length = 3; length <= n; length++) {            // TC: O(N)
            for (int i = 0; i <= n - length; i++) {              // TC: O(N)
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
