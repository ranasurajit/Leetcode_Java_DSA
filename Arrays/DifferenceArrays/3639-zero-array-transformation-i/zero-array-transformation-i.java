class Solution {
    /**
     * Approach : Using Difference Arrays Approach
     *
     * TC: O(2 x N + Q) ~ O(N + Q)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // create a difference array with all elements 0
        int[] diff = new int[n]; // SC: O(N)
        for (int[] query : queries) { // TC: O(Q)
            int start = query[0];
            int end = query[1];
            diff[start] += 1;
            if (end + 1 < n) {
                diff[end + 1] -= 1;
            }
        }
        int cumulativeSum = 0;
        int[] result = new int[n]; // SC: O(N)
        // pre-fill all elements of result with prefix sum of 'diff' array
        for (int i = 0; i < n; i++) { // TC: O(N)
            cumulativeSum += diff[i];
            result[i] = cumulativeSum;
        }
        // check if it is possible to reduce 'nums' array to zero array
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (result[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
