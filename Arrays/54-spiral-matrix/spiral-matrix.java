class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        List<Integer> order = new ArrayList<Integer>();

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int count = 0; // 0 -> L to R, 1 -> T to D, 2 -> R to L, 3 -> D to T
        int directions = 4;

        while (order.size() < m * n) {
            count = count % directions;
            if (count == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    order.add(matrix[top][i]);
                }
                top += 1;
            } else if (count == 1) {
                // top to down
                for (int i = top; i <= bottom; i++) {
                    order.add(matrix[i][right]);
                }
                right -= 1;
            } else if (count == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    order.add(matrix[bottom][i]);
                }
                bottom -= 1;
            } else if (count == 3) {
                // down to top
                for (int i = bottom; i >= top; i--) {
                    order.add(matrix[i][left]);
                }
                left += 1;
            }
            count++;
        }
        return order;
    }
}