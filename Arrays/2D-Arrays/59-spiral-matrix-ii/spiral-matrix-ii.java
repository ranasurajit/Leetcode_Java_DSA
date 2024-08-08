class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int current = 0;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int data = 1;
        while (top <= bottom && left <= right && data <= n * n) {
            if (current == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = data;
                    data++;
                }
                top = top + 1;
            } else if (current == 1) {
                // top to bottom
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = data;
                    data++;
                }
                right = right - 1;
            } else if (current == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = data;
                    data++;
                }
                bottom = bottom - 1;
            } else if (current == 3) {
                // bottom to top
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = data;
                    data++;
                }
                left = left + 1;
            }
            current = (current + 1) % 4;
        }
        return matrix;
    }
}
