class Solution {
    private int[][] grid;
    private int n;
    private int m;
    // ↘, ↙, ↖, ↗
    private static final int[][] directions = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N X M X 2 ^ (Min(N, M)))
     * SC: O(Min(N, M))
     */
    public int lenOfVDiagonal(int[][] grid) {
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
        if (row < 0 || row >= n || col < 0 || col >= m) {
            // out of bounds
            return 0;
        }
        if (grid[row][col] != expect) {
            return 0;
        }
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
