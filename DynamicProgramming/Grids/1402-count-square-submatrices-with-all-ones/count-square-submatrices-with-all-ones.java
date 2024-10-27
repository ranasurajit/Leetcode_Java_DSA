class Solution {
    /**
     * TC: O(M x N + M + N) ~ O(M x N)
     * SC: O(1)
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        int count = dp[0][0] == 1 ? 1 : 0;

        for (int i = 1; i < n; i++) { // TC: O(N)
            dp[0][i] = matrix[0][i];
            if (dp[0][i] == 1) {
                count++;
            }
        }
        for (int i = 1; i < m; i++) { // TC: O(M)
            dp[i][0] = matrix[i][0];
            if (dp[i][0] == 1) {
                count++;
            }
        }
        for (int i = 1; i < m; i++) { // TC: O(M x N)
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] == 1 ? 
                    matrix[i][j] + 
                    Math.min(dp[i - 1][j - 1], 
                    Math.min(dp[i - 1][j], dp[i][j - 1]))
                    : 0;
                count += dp[i][j];
            }
        }
        return count;
    }
}
