class Solution {
    /**
     * TC: O(Q)
     * SC: O(1)
     */
    public int maxCount(int m, int n, int[][] ops) {
        int minRows = m;
        int minCols = n;
        // we need to find the minimum intersection of cells in the 'ops' array
        for (int[] operation : ops) { // TC: O(Q)
            minRows = Math.min(minRows, operation[0]);
            minCols = Math.min(minCols, operation[1]);
        }
        return minRows * minCols;
    }
}
