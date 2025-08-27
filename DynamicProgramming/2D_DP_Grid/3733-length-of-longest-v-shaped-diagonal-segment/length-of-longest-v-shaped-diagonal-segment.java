class Solution {
    private int[][] grid;
    private int n;
    private int m;
    // ↘, ↙, ↖, ↗
    private static final int[][] directions = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N ^ 2 x M ^ 2)
     * SC: O(N x M) + O(Min(N, M))
     */
    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        int maxLength = 0;
        /**
         * states are row, col, directions (0 - 4) and turned (0-1)
         */ 
        Integer[][][][] memo = new Integer[n][m][4][2];
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < directions.length; dir++) {
                        maxLength = Math.max(maxLength, 
                            1 + solveMemoization(i + directions[dir][0], 
                                j + directions[dir][1], 2, dir, 0, memo));
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x M)
     * SC: O(Min(N, M))
     */
    private int solveMemoization(int row, int col, int expect, int dir, 
        int turned, Integer[][][][] memo) {
        // Base Case
        if (row < 0 || row >= n || col < 0 || col >= m) {
            // out of bounds
            return 0;
        }
        if (grid[row][col] != expect) {
            return 0;
        }
        // Memoization Check
        if (memo[row][col][dir][turned] != null) {
            return memo[row][col][dir][turned];
        }
        // Recursion Calls
        int nextExpect = expect == 2 ? 0 : 2;
        int maxLength = 1;
        // continue in the same path
        maxLength = Math.max(maxLength, 
            1 + solveMemoization(row + directions[dir][0], 
                col + directions[dir][1], nextExpect, dir, turned, memo));
        // turn the direction if not turned already
        if (turned == 0) {
            int newDir = (dir + 1) % 4;
            maxLength = Math.max(maxLength, 
                1 + solveMemoization(row + directions[newDir][0],
                    col + directions[newDir][1], nextExpect, newDir, 1, memo));
        }
        return memo[row][col][dir][turned] = maxLength;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N X M X 2 ^ (Min(N, M)))
     * SC: O(Min(N, M))
     */
    public int lenOfVDiagonalRecursion(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < directions.length; dir++) {
                        maxLength = Math.max(maxLength, 
                            1 + solveRecursion(i + directions[dir][0], j + directions[dir][1], 2, dir, 0));
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ (Min(N, M)))
     * SC: O(Min(N, M))
     */
    private int solveRecursion(int row, int col, int expect, int dir, int turned) {
        // Base Case
        if (row < 0 || row >= n || col < 0 || col >= m) {
            // out of bounds
            return 0;
        }
        if (grid[row][col] != expect) {
            return 0;
        }
        // Recursion Calls
        int nextExpect = expect == 2 ? 0 : 2;
        int maxLength = 1;
        // continue in the same path
        maxLength = Math.max(maxLength, 
            1 + solveRecursion(row + directions[dir][0], 
                col + directions[dir][1], nextExpect, dir, turned));
        // turn the direction if not turned already
        if (turned == 0) {
            int newDir = (dir + 1) % 4;
            maxLength = Math.max(maxLength, 
                1 + solveRecursion(row + directions[newDir][0],
                    col + directions[newDir][1], nextExpect, newDir, 1));
        }
        return maxLength;
    }
}
