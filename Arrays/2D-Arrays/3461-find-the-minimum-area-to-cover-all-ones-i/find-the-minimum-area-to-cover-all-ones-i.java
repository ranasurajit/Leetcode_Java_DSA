class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minRow = m;
        int maxRow = -1;
        int minCol = n;
        int maxCol = -1;
        for (int i = 0; i < m; i++) {     // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if (minRow < 0 || maxRow == m || minCol < 0 || maxCol == n) {
            return 0;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
