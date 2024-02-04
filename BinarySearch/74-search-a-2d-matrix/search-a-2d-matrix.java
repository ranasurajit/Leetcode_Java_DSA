class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // row
        int n = matrix[0].length; // col
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int eRow = mid / n;
            int eCol = mid % n;
            if (matrix[eRow][eCol] == target) {
                return true;
            } else if (target > matrix[eRow][eCol]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}