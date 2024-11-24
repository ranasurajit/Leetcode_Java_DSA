class Solution {
    /**
     * TC: O(N x N)
     * SC: O(1)
     */
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length; // it is a n x n matrix
        int countNeg = 0;
        long total = 0L;
        int smallest = Integer.MAX_VALUE;
        for (int[] row : matrix) { // TC: O(N)
            for (int col : row) {  // TC: O(N
                if (col < 0) {
                    countNeg++;
                    total += (-1 * col);
                } else {
                    total += col;
                }
                smallest = Math.min(smallest, Math.abs(col));
            }
        }
        /*
         * if negative numbers count is even we can make 
         * everything positive else we will be left with 
         * atleast 1 negative. So it is better to make the least
         * absolute value as negative and substract it from total
         */
        if (countNeg % 2 == 0) {
            return total;
        } else {
            // subtracting the smallest absolute number twice from total
            return total - 2 * smallest;
        }
    }
}
