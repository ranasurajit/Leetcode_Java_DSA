class Solution {
    public int uniquePaths(int m, int n) {
        // return uniquePathsRecursion(m - 1, n - 1);
        int[][] dp = new int[m][n];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return uniquePathsMemoization(m - 1, n - 1, dp);
    }

    /**
     * Using Memoization
     * 
     * TC: O(M x N)
     * SC: O((M - 1) + (N - 1) + (M x N))
     * 
     * @param m
     * @param n
     * @return
     */
    public static int uniquePathsMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1; // reached destination
        }
        if (m < 0 || n < 0) {
            return 0; // reached out of bounds of grid so returned 0
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int upPaths = uniquePathsMemoization(m - 1, n, dp);
        int leftPaths = uniquePathsMemoization(m, n - 1, dp);
        dp[m][n] = upPaths + leftPaths;
        return dp[m][n];
    }

    /**
     * Using Recursion
     * 
     * TC: O(2 ^ (M x N))
     * SC: O((M - 1) + (N - 1))
     * 
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathsRecursion(int m, int n) {
        if (m == 0 && n == 0) {
            return 1; // reached destination
        }
        if (m < 0 || n < 0) {
            return 0; // reached out of bounds of grid so returned 0
        }
        int upPaths = uniquePathsRecursion(m - 1, n);
        int leftPaths = uniquePathsRecursion(m, n - 1);
        return upPaths + leftPaths;
    }
}
