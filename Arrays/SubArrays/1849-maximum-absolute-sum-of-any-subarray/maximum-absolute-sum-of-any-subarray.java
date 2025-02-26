class Solution {
    /**
     * Optimal Approach (Kadane's Algorithm)
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSumMax = nums[0];
        int minSum = nums[0];
        int currentSumMin = nums[0];
        // computing max sum
        for (int i = 1; i < n; i++) {  // TC: O(N)
            currentSumMax = Math.max(nums[i], currentSumMax + nums[i]);
            maxSum = Math.max(maxSum, currentSumMax);

            currentSumMin = Math.min(nums[i], currentSumMin + nums[i]);
            minSum = Math.min(minSum, currentSumMin);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(2 x N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     */
    public int maxAbsoluteSumBruteForce(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        // computing max sum
        for (int i = 0; i < n; i++) {      // TC: O(N)
            int currentSum = 0;
            for (int j = i; j < n; j++) {  // TC: O(N)
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        // computing min sum
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int currentSum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                currentSum += nums[j];
                minSum = Math.min(minSum, currentSum);
            }
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
