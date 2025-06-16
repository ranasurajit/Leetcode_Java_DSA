class Solution {
    /**
     * Approach : Using Array Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int minTillIndex = Integer.MAX_VALUE;
        int maxDiff = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            minTillIndex = Math.min(minTillIndex, nums[i]);
            if (nums[i] > minTillIndex) {
                maxDiff = Math.max(maxDiff, nums[i] - minTillIndex);
            }
        }
        return maxDiff;
    }
}
