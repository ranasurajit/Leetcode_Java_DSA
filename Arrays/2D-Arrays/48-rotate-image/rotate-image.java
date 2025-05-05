class Solution {
    /**
     * Approach: Reverse the Rows of the Matrix and Transform It
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // reverse the columns
        reverseRows(matrix, 0, n - 1); // TC: O(N)
        // transpose the matrix
        transpose(matrix, n); // TC: O(N ^ 2)
    }

    /**
     * Reverse the Rows of the Matrix
     *
     * TC: O(N)
     * SC: O(1)
     */
    private void reverseRows(int[][] matrix, int start, int end) {
        while (start < end) {
            // swap the rows
            int[] temp = matrix[end];
            matrix[end] = matrix[start];
            matrix[start] = temp;
            start++;
            end--;
        }
    }

    /**
     * Transpose the Matrix
     *
     * TC: O((N ^ 2) / 2) ~ O(N ^ 2)
     * SC: O(1)
     */
    private void transpose(int[][] matrix, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
