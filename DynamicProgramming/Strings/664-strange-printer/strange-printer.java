class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solve(0, n - 1, s, dp);
    }

    private int solve(int left, int right, String s, int[][] dp) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int i = left + 1;
        while (i <= right && s.charAt(i) == s.charAt(left)) {
            i++;
        }
        if (i == right + 1) {
            return 1;
        }
        // basic approach - print similar sequence of characters and change when needed
        int x = 1 + solve(i, right, s, dp);
        // greedy approach - print all same letters together and then modify
        int y = Integer.MAX_VALUE;
        for (int j = i; j <= right; j++) {
            if (s.charAt(j) == s.charAt(left)) {
                // sequence of different characters + sequence that starts with character at left
                int greed = solve(i, j - 1, s, dp) + solve(j, right, s, dp);
                y = Math.min(y, greed);
            }
        }
        dp[left][right] = Math.min(x, y);
        return dp[left][right];
    }
}
