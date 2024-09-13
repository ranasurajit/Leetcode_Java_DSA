class Solution {
    /**
     * TC: O(N + M), where M is the number of queries
     * SC: O(1)
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        for (int i = 1; i < n; i++) { // TC: O(N)
            arr[i] = arr[i - 1] ^ arr[i];
        }
        int[] result = new int[m];
        for (int i = 0; i < m; i++) { // TC: O(M)
            if (queries[i][0] > 0) {
                // using the property of XOR which cancels the XOR of same numbers
                result[i] = arr[queries[i][1]] ^ arr[queries[i][0] - 1];
            } else {
                result[i] = arr[queries[i][1]];
            }
        }
        return result;
    }
}
