class Solution {
    /**
     * Unguarded cell = 0
     * Guarded Cell   = 1
     * Guard Cell     = 2
     * Wall Cell      = 3
     *
     * TC: O(M x N + 5x G + W) ~ O(M x N)
     * SC: O(M x N)
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n]; // SC: O(M x N)
        // marking guards in grid with 2
        for (int[] guard : guards) { // TC: O(G)
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 2;
        }
        // marking walls in grid with 3
        for (int[] wall : walls) { // TC: O(W)
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 3;
        }
        // marking the guard sight in all four directions
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // up right down left
        for (int[] guard : guards) { // TC: O(G)
            int row = guard[0];
            int col = guard[1];
            for (int i = 0; i < dir.length; i++) { // TC: O(4)
                int delRow = row + dir[i][0];
                int delCol = col + dir[i][1];
                dfsGrid(delRow, delCol, grid, i, m, n);
            }
        }
        // count number of grid cells unmarked
        int count = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    private void dfsGrid(int row, int col, int[][] grid, int dir, int m, int n) {
        // Base case
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if (grid[row][col] == 2 || grid[row][col] == 3) {
            // grid cell has wall so cannot go further
            return;
        }
        grid[row][col] = 1;
        if (dir == 0) {
            dfsGrid(row - 1, col, grid, dir, m, n); // up
        } else if (dir == 1) {
            dfsGrid(row, col + 1, grid, dir, m, n); // right
        } else if (dir == 2) {
            dfsGrid(row + 1, col, grid, dir, m, n); // down
        } else if (dir == 3) {
            dfsGrid(row, col - 1, grid, dir, m, n); // left
        }
    }
}
