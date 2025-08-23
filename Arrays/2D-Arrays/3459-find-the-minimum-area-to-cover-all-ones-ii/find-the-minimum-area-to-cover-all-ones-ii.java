class Solution {
    private int m;
    private int n;
    private int[][] grid;

    /**
     * Approach : Using Simulation Approach
     *
     * TC: O((M x M x N x N) x (M + N))
     * SC: O(1)
     */
    public int minimumSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        /**
         * we need to divide the grid in (1 + 2) or (2 + 1) rows and column grids so that
         * it does not include any overlapping cells and later on 2 row and 2 column grids
         * can be looked up for (1 + 1) rows and column partitions
         */
        int result = Integer.MAX_VALUE / 3;
        // row-wise cuts
        for (int i = 0; i < m - 1; i++) { // TC: O(M)
            result = Math.min(result, Math.min(
                oneArea(0, 0, i, n - 1) + twoArea(i + 1, 0, m - 1, n - 1),
                twoArea(0, 0, i, n - 1) + oneArea(i + 1, 0, m - 1, n - 1)
            ));
        }
        // column-wise cuts
        for (int j = 0; j < n - 1; j++) { // TC: O(N)
            result = Math.min(result, Math.min(
                oneArea(0, 0, m - 1, j) + twoArea(0, j + 1, m - 1, n - 1),
                twoArea(0, 0, m - 1, j) + oneArea(0, j + 1, m - 1, n - 1)
            ));
        }
        return result;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(M x M x N) + O(M x N x N)
     * SC: O(1)
     */
    private int twoArea(int r1, int c1, int r2, int c2) {
        int result = Integer.MAX_VALUE / 2;
        // row-wise cuts
        for (int i = r1; i < r2; i++) { // TC: O(M)
            result = Math.min(result, oneArea(r1, c1, i, c2) + oneArea(i + 1, c1, r2, c2));
        }
        // column-wise cuts
        for (int j = c1; j < c2; j++) { // TC: O(N)
            result = Math.min(result, oneArea(r1, c1, r2, j) + oneArea(r1, j + 1, r2, c2));
        }
        return result;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    private int oneArea(int r1, int c1, int r2, int c2) {
        int minRow = r2 + 1;
        int maxRow = -1;
        int minCol = c2 + 1;
        int maxCol = -1;
        boolean hasOnes = false;
        for (int i = r1; i <= r2; i++) { // TC: O(R2 - R1 + 1)
            for (int j = c1; j <= c2; j++) { // TC: O(C2 - C1 + 1)
                if (grid[i][j] == 1) {
                    hasOnes = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        return !hasOnes ? Integer.MAX_VALUE / 4 : (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
