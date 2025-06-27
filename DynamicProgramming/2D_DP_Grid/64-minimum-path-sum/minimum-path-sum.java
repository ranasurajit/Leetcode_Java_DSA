class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(M x N)
     * SC: O((M x N) + (M - 1) + (N - 1))
     *
     * Accepted (66 / 66 testcases passed)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(m - 1, n - 1, grid, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O((M x N) + (M - 1) + (N - 1))
     */
    private int solveMemoization(int m, int n, int[][] grid, int[][] memo) {
        // Base Case
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (m < 0 || n < 0) {
            // as we need minimum value so invalid case is returned with a higher value
            return (int) 1e9;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        // Hypothesis
        int pathSumTop = grid[m][n] + solveMemoization(m - 1, n, grid, memo);
        int pathSumLeft = grid[m][n] + solveMemoization(m, n - 1, grid, memo);
        // Induction
        return memo[m][n] = Math.min(pathSumTop, pathSumLeft);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ ((M - 1) x (N - 1)))
     * SC: O((M - 1) + (N - 1))
     *
     * Time Limit Exceeded (25 / 66 testcases passed)
     */
    public int minPathSumRecursion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solveRecursion(m - 1, n - 1, grid);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ ((M - 1) x (N - 1)))
     * SC: O((M - 1) + (N - 1))
     */
    private int solveRecursion(int m, int n, int[][] grid) {
        // Base Case
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (m < 0 || n < 0) {
            // as we need minimum value so invalid case is returned with a higher value
            return (int) 1e9;
        }
        // Recursion Calls
        // Hypothesis
        int pathSumTop = grid[m][n] + solveRecursion(m - 1, n, grid);
        int pathSumLeft = grid[m][n] + solveRecursion(m, n - 1, grid);
        // Induction
        return Math.min(pathSumTop, pathSumLeft);
    }
}
