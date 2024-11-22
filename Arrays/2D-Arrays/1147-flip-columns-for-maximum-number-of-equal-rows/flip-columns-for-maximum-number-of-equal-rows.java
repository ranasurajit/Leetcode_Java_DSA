class Solution {
    /**
     * TC: O(4 x M x N) ~ O(M x N)
     * SC: O(M)
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); // SC: O(M)
        for (int[] row : matrix) { // TC: O(M)
            String key = Arrays.toString(row); // TC: O(N)
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        int maxRows = 0;
        for (int[] row : matrix) { // TC: O(M)
            String key = Arrays.toString(row); // TC: O(N)
            String oppKey = Arrays.toString(flippedRow(row)); // TC: O(2 x N)
            maxRows = Math.max(maxRows, hm.getOrDefault(key, 0) + hm.getOrDefault(oppKey, 0));
        }
        return maxRows;
    }

    /**
     * TC: O(N)
     * SC: O(1) - inplace flipped
     */
    private int[] flippedRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] == 0 ? 1 : 0;
        }
        return row;
    }
}
