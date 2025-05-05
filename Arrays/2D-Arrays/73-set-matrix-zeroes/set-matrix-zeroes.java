class Solution {
    /**
     * Approach II : Using Inplace Replacement Approach
     *
     * TC: O(2 x (M x N) + (M + N)) ~ O(M x N)
     * SC: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int colZero = 1;
        // marking the 0th column as zero (i >= 0 & i < m) and 0th row as zero (j > 0 & j < n) 
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        colZero = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        // marking all matrix elements from (1, 1) to (m - 1, n - 1)
        for (int i = 1; i < m; i++) { // TC: O(M)
            for (int j = 1; j < n; j++) { // TC: O(N)
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // marking the 0th column elements as zero if matrix[0][0] = 0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) { // TC: O(M)
                matrix[0][j] = 0;
            }
        }
        // marking the 0th row elements as zero if colZero = 0
        if (colZero == 0) {
            for (int i = 0; i < m; i++) { // TC: O(N)
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x M x N) ~ O(M x N)
     * SC: O(M + N)
     */
    public void setZeroesUsingHashing(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rowset = new HashSet<Integer>(); // SC: O(M)
        Set<Integer> colset = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (matrix[i][j] == 0) {
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (rowset.contains(i) || colset.contains(j)) {
                    matrix[i][j] = 0;
                } 
            }
        }
    }
}
