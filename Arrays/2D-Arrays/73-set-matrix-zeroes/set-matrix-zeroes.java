class Solution {
    /**
     * Approach: Using Hashing Approach
     *
     * TC: O(2 x M x N) ~ O(M x N)
     * SC: O(M + N)
     */
    public void setZeroes(int[][] matrix) {
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
