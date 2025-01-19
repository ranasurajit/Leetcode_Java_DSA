class Solution {
    /**
     * Using Array Pre-processing i.e. (Prefix Sum) Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n]; // SC: O(N)
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int start = Math.max(0, i - nums[i]);
            if (start > 0) {
                sum += prefixSum[i] - prefixSum[start - 1];
            } else {
                sum += prefixSum[i];
            }
        }
        return sum;
    }
}
