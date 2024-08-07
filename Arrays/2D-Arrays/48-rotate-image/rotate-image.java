class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose of matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // rotate all row arrays
        for (int[] row : matrix) {
            reverseArray(row);
        }
    }

    private void reverseArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }
}
