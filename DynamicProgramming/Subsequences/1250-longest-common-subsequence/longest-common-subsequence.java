class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = 0;
                int y = 0;
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //  took 1 character and continued
                    x = 1 + dp[i - 1][j - 1];
                } else {
                    //  did not take any character and continued
                    y = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[m][n];
    }
}
