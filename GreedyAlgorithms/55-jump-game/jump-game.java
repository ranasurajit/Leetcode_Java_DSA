class Solution {
    /**
     * Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (maxIndex < i) {
                // cannot move further
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
