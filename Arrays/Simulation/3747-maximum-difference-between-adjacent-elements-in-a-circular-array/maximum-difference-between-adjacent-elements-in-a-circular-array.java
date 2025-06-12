class Solution {
    /**
     * Approach II : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            int currentDiff = Math.abs(nums[i] - nums[i - 1]);
            maxDiff = Math.max(maxDiff, currentDiff);
        }
        return maxDiff;
    }

    /**
     * Approach I : Using Simulation + Circular Array Property Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int maxAdjacentDistanceApproachI(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < 2 * n; i++) { // TC: O(2 x N)
            int currentDiff = Math.abs(nums[i % n] - nums[(i - 1 + n) % n]);
            maxDiff = Math.max(maxDiff, currentDiff);
        }
        return maxDiff;
    }
}
