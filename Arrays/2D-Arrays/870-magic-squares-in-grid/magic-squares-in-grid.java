class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int rs, int cs) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int element = grid[rs + i][cs + j];
                // check if element lies between 1 to 9 or is not duplicated
                if (element < 1 || element > 9 || hs.contains(element)) {
                    return false;
                } else {
                    hs.add(element);
                }
            }
        }
        int rsum = grid[rs][cs] + grid[rs][cs + 1] + grid[rs][cs + 2];
        for (int i = 0; i < 3; i++) {
            int currentRsum = grid[rs + i][cs] + grid[rs + i][cs + 1] + grid[rs + i][cs + 2];
            // check if all row sums are same
            if (currentRsum != rsum) {
                return false;
            }
            int currentCsum = grid[rs][cs + i] + grid[rs + 1][cs + i] + grid[rs + 2][cs + i];
            // check if all column sums are same
            if (currentCsum != rsum) {
                return false;
            }
        }
        // check if diagonal sums are same
        int diagSum = grid[rs][cs] + grid[rs + 1][cs + 1] + grid[rs + 2][cs + 2];
        if (diagSum != rsum) {
            return false;
        }
        // check if anti-diagonal sums are same
        int antiDiagSum = grid[rs][cs + 2] + grid[rs + 1][cs + 1] + grid[rs + 2][cs];
        if (antiDiagSum != rsum) {
            return false;
        }
        return true;
    }
}
