class Solution {
    /**
     * Approach : Using Simulation + Circular Array Property Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < 2 * n; i++) { // TC: O(2 x N)
            int currentDiff = Math.abs(nums[i % n] - nums[(i - 1 + n) % n]);
            maxDiff = Math.max(maxDiff, currentDiff);
        }
        return maxDiff;
    }
}
