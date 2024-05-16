class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > reachable) {
                return false;
            }
            if (reachable < nums[i] + i) {
                reachable = nums[i] + i;
            }
        }
        return true;
    }
}
