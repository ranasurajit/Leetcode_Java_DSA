class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O((M x N) + (M + N))
     *
     * Accepted (66 / 66 testcases passed)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m + 1][n + 1]; // SC: O(M x N)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(m - 1, n - 1, grid, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O((M - 1) + (N - 1)) ~ O(M + N)
     */
    private int solveMemoization(int i, int j, int[][] grid, int[][] memo) {
        // Base Case
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) 1e9 + 7;
        }
        // Memoization Check
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // Recursive Calls
        int up = grid[i][j] + solveMemoization(i - 1, j, grid, memo);
        int down = grid[i][j] + solveMemoization(i, j - 1, grid, memo);
        return memo[i][j] = Math.min(up, down);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ (M x N))
     * SC: O((M - 1) + (N - 1)) ~ O(M + N)
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
     * TC: O(2 ^ (M x N))
     * SC: O((M - 1) + (N - 1)) ~ O(M + N)
     */
    private int solveRecursion(int i, int j, int[][] grid) {
        // Base Case
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) 1e9 + 7;
        }
        // Recursive Calls
        int up = grid[i][j] + solveRecursion(i - 1, j, grid);
        int down = grid[i][j] + solveRecursion(i, j - 1, grid);
        return Math.min(up, down);
    }
}
