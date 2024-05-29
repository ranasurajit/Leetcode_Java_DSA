class Solution {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        // Using Recursion
        // return checkMatchRecursion(sl - 1, pl - 1, s, p);
        // Using Memoization
        int[][] dp = new int[sl][pl];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int matched = checkMatchMemoization(sl - 1, pl - 1, s, p, dp);
        return matched == 1;
    }

    /**
     * Using Memoization
     */
    private int checkMatchMemoization(int sl, int pl, String s, String p, int[][] dp) {
        if (sl < 0 && pl < 0) {
            // both strings exhaused after matching/shrinking
            return 1;
        }
        if (pl < 0 && sl >= 0) {
            // pattern exhaused and text still left
            return 0;
        }
        if (sl < 0 && pl >= 0) {
            // text exhaused but pattern still left then check if all of the remaining are *
            for (int i = 0; i <= pl; i++) {
                if (p.charAt(i) != '*') {
                    return 0;
                }
            }
            return 1;
        }
        if (dp[sl][pl] != -1) {
            return dp[sl][pl];
        }
        if (p.charAt(pl) == s.charAt(sl) || p.charAt(pl) == '?') {
            dp[sl][pl] = checkMatchMemoization(sl - 1, pl - 1, s, p, dp);
            return dp[sl][pl];
        }
        if (p.charAt(pl) == '*') {
            dp[sl][pl] = (checkMatchMemoization(sl - 1, pl, s, p, dp) == 1 || 
                checkMatchMemoization(sl, pl - 1, s, p, dp) == 1) ? 1 : 0;
            return dp[sl][pl];
        }
        dp[sl][pl] = 0;
        return dp[sl][pl];
    }

    /**
     * Using Recursion
     */
    private boolean checkMatchRecursion(int sl, int pl, String s, String p) {
        if (sl < 0 && pl < 0) {
            // both strings exhaused after matching/shrinking
            return true;
        }
        if (pl < 0 && sl >= 0) {
            // pattern exhaused and text still left
            return false;
        }
        if (sl < 0 && pl >= 0) {
            // text exhaused but pattern still left then check if all of the remaining are *
            for (int i = 0; i <= pl; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (p.charAt(pl) == s.charAt(sl) || p.charAt(pl) == '?') {
            return checkMatchRecursion(sl - 1, pl - 1, s, p);
        }
        if (p.charAt(pl) == '*') {
            return checkMatchRecursion(sl - 1, pl, s, p) || checkMatchRecursion(sl, pl - 1, s, p);
        }
        return false;
    }
}
