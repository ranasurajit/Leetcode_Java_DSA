class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                // reset the sum to current element
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
