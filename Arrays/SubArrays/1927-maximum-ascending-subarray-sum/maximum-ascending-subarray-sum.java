class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int currentMax = Integer.MIN_VALUE;
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > currentMax) {
                currentMax = nums[i];
                currentSum += nums[i];
                maxSum = Math.max(maxSum, currentSum);
            } else {
                currentMax = nums[i];
                currentSum = nums[i];
            }
        }
        return maxSum;
    }
}
