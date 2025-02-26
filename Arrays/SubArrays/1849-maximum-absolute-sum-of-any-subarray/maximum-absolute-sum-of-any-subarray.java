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
        int currentSum = nums[0];
        // computing max sum
        for (int i = 1; i < n; i++) {  // TC: O(N)
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        int minSum = nums[0];
        currentSum = nums[0];
        // computing min sum
        for (int i = 1; i < n; i++) {  // TC: O(N)
            currentSum = Math.min(nums[i], currentSum + nums[i]);
            minSum = Math.min(minSum, currentSum);
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
