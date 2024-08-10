class Solution {
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        /**
         * We need to fill 
         *  "/"     ,      "\"      and   " " with 3 x 3 matrix of 0s and 1s as below 
         * 0 0 1          1 0 0          0 0 0
         * 0 1 0          0 1 0          0 0 0
         * 1 0 0          0 0 1          0 0 0                       
         */
        int[][] matrix = new int[rows * 3][cols * 3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int regions = 0;
        for (int i = 0 ; i < rows * 3; i++) {
            for (int j = 0 ; j < cols * 3; j++) {
                if (matrix[i][j] == 0) {
                    dfsGraph(matrix, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private void dfsGraph(int[][] matrix, int i, int j) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || matrix[i][j] == 1) {
            return;
        }
        matrix[i][j] = 1;
        dfsGraph(matrix, i - 1, j); // Direction up
        dfsGraph(matrix, i + 1, j); // Direction down
        dfsGraph(matrix, i, j - 1); // Direction left
        dfsGraph(matrix, i, j + 1); // Direction right
    }
}
