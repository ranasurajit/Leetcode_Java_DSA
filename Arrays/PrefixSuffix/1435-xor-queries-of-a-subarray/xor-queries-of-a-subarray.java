class Solution {
    /**
     * TC: O(N + M), where M is the number of queries
     * SC: O(N)
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] prefixXOR = new int[n]; // SC: O(N)
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        int[] result = new int[m];
        for (int i = 0; i < m; i++) { // TC: O(M)
            int[] q = queries[i];
            if (q[0] > 0) {
                // using the property of XOR which cancels the XOR of same numbers
                result[i] = prefixXOR[q[1]] ^ prefixXOR[q[0] - 1];
            } else {
                result[i] = prefixXOR[q[1]];
            }
        }
        return result;
    }
}
