class Solution {
    /**
     * Optimal Approach (Kadane's Algorithm)
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int maxSubArrayBruteForceApproach(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int currentSum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
