class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max1s = 0;
        int rowIndex = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            int count1s = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (mat[i][j] == 1) {
                    count1s++;
                }
            }
            if (max1s < count1s) {
                max1s = count1s;
                rowIndex = i;
            }
        }
        return new int[] { rowIndex, max1s };
    }
}
