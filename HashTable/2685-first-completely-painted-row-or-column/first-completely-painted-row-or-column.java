class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(3 x M x N) ~ O(M x N)
     * SC: O(M x N)
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int k = arr.length;
        // as per question the elements are unique so we can store elements in HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) { // TC: O(M x N)
            map.put(arr[i], i);
        }
        int m = mat.length;
        int n = mat[0].length;
        /**
         * verifying in each row to find minimum index at which
         * each row would be painted
         */
        int minRowIndex = k;
        for (int i = 0; i < m; i++) { // TC: O(M)
            int currentIndex = -1;
            for (int j = 0; j < n; j++) { // TC: O(N)
                currentIndex = Math.max(currentIndex, map.get(mat[i][j]));
            }
            minRowIndex = Math.min(minRowIndex, currentIndex);
        }
        /**
         * verifying in each column to find minimum index at which
         * each column would be painted
         */
        int minColIndex = k;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int currentIndex = -1;
            for (int j = 0; j < m; j++) { // TC: O(M)
                currentIndex = Math.max(currentIndex, map.get(mat[j][i]));
            }
            minColIndex = Math.min(minColIndex, currentIndex);
        }
        // return the min of minRowIndex and minColIndex
        return Math.min(minRowIndex, minColIndex);
    }
}
