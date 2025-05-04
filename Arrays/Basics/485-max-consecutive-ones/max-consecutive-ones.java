class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maxCount = 0;
        int currentCount = 0;
        while (i < n) { // TC: O(N)
            if (nums[i] == 0) {
                // reset currentCount
                currentCount = 0;
            } else {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            }
            i++;
        }
        return maxCount;
    }
}
