class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        long currentSum = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            currentSum += nums[j];
            if (currentSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
            }
            // shrink the window
            while (currentSum - nums[i] >= target) {
                currentSum -= nums[i];
                i++;
                minLength = Math.min(minLength, j - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
