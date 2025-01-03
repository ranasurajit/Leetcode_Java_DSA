class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n]; // SC: O(N)
        prefixSum[0] = (long) nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + (long) nums[i];
        }
        long count = 0L;
        for (int i = 1; i < n; i++) { // TC: O(N)
            long leftSum = prefixSum[i - 1];
            long rightSum = prefixSum[n - 1] - prefixSum[i - 1];
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return (int) count;
    }
}
