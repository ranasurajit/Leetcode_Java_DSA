class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];
        // populate 0th index row
        for (int i = 0; i < n; i++) {
            prev[i] = points[0][i];
        }
        // process each row starting from index i = 1
        for (int row = 1; row < m; row++) {
            long[] current = new long[n];
            long[] left = new long[n];
            long[] right = new long[n];
            // populate left values
            left[0] = prev[0];
            for (int col = 1; col < n; col++) {
                left[col] = Math.max(left[col - 1] - 1, prev[col]);
            }
            // populate right values
            right[n - 1] = prev[n - 1];
            for (int col = n - 2; col >= 0; col--) {
                right[col] = Math.max(right[col + 1] - 1, prev[col]);
            }
            // calculate best possible points in current
            for (int col = 0; col < n; col++) {
                current[col] = points[row][col] + Math.max(left[col], right[col]);
            }
            // prepare for next iteration
            prev = current;
        }
        // return maximum value from last row
        long max = Long.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            max = Math.max(max, prev[col]);
        }
        return max;
    }
}
