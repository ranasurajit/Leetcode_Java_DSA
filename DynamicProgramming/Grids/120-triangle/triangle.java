class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return solve(0, 0, triangle);
        int n = triangle.size();
        int[][] dp = new int[n][n + 1]; // SC: O(N x N)
        for (int[] dp1D : dp) { // TC: O(N x N)
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(0, 0, triangle, dp);
    }

    /**
     * Using Memoization
     * 
     * TC: O(N x N)
     * SC: O(N x N)
     * 
     * @param triangle
     * @return
     */
    private static int solveMemoization(int m, int n, List<List<Integer>> triangle, int[][] dp) {
        if (m == triangle.size()) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int down = triangle.get(m).get(n) + solveMemoization(m + 1, n, triangle, dp);
        int diag = triangle.get(m).get(n) + solveMemoization(m + 1, n + 1, triangle, dp);
        dp[m][n] = Math.min(down, diag);
        return dp[m][n];
    }

    private static int solveRecursion(int m, int n, List<List<Integer>> triangle) {
        if (m == triangle.size()) {
            return 0;
        }
        int down = triangle.get(m).get(n) + solveRecursion(m + 1, n, triangle);
        int diag = triangle.get(m).get(n) + solveRecursion(m + 1, n + 1, triangle);
        return Math.min(down, diag);
    }
}
