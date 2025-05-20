class Solution {
    /**
     * Approach II : Using Binary Search Approach (Eliminate Rows and Columns)
     *
     * TC: O(M + N)
     * SC: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        /**
         * we point the starting point at (0, n - 1) as 
         * row-wise the value decreases from right to left and
         * increases from top to bottom so, it will be easy to
         * eliminate either column (reduce column index) and 
         * row (increase row index)
         */
        while (row < m && col >= 0) { // TC: O(M + N)
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // target cannot be present in the current column
                col--;
            } else if (matrix[row][col] < target) {
                // target cannot be present in the current row
                row++;
            }
        }
        return false;
    }

    /**
     * Approach I : Using Binary Search On Rows Approach
     *
     * TC: O(M x log(N))
     * SC: O(1)
     */
    public boolean searchMatrixBetter(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) { // TC: O(M)
            if (target >= matrix[i][0] && target <= matrix[i][n - 1] &&
                searchElement(matrix[i], n, target)) { // TC: O(log(N))
                return true;
            }
        }
        return false;
    }

    /**
     * Using Binary Search Approach on Row
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private boolean searchElement(int[] row, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
