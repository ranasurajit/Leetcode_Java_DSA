class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i > maxPosition) {
                return false;
            }
            // for any index 'i', we can jump from (i + 1) to (i + nums[i]) position
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (maxPosition >= n - 1) {
                return true;
            }
        }
        return true;
    }
}
