class Solution {
    /**
     * Approach : Using Matrix Traversal Approach
     *
     * TC: O(N x M) as all cells will be visited exactly once
     * SC: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                // left to right traversal
                for (int i = left; i <= right; i++) { // TC: O(M)
                    path.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) {
                // top to bottom traversal
                for (int i = top; i <= bottom; i++) { // TC: O(N)
                    path.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {
                // right to left traversal
                for (int i = right; i >= left; i--) { // TC: O(M)
                    path.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (direction == 3) {
                // bottom to top traversal
                for (int i = bottom; i >= top; i--) { // TC: O(N)
                    path.add(matrix[i][left]);
                }
                left++;
            }
            direction++;
            direction = direction % 4;
        }
        return path;
    }
}
