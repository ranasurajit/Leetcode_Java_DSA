class Solution {
    /**
     * TC: O(N^3)
     * SC: O(number of words in dictionary + recursion stack N) ~ O(N)
     */
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> hs = new HashSet<String>();
        for (String str : dictionary) {
            hs.add(str);
        }
        int[] dp = new int[51]; // due to constraints
        Arrays.fill(dp, -1);
        return solve(0, s, n, hs, dp);
    }

    private int solve(int i, String s, int n, HashSet<String> hs, int[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        // skip
        int result = 1 + solve(i + 1, s, n, hs, dp);
        // not skip
        for (int j = i; j < n; j++) {
            String current = s.substring(i, j + 1);
            if (hs.contains(current)) {
                result = Math.min(result, solve(j + 1, s, n, hs, dp));
            }
        }
        return dp[i] = result;
    }
}
