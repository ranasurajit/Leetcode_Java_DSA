class Solution {
    public boolean canJump(int[] nums) {
        // int reachable = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (i > reachable) {
        //         return false;
        //     }
        //     if (reachable < nums[i] + i) {
        //         reachable = nums[i] + i;
        //     }
        // }
        // return true;

        int left = 0;
        int right = 0;
        int farthest = 0;
        while (right < nums.length - 1) {
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right + 1;
            right = farthest;
            if (left > right) {
                return false;
            }
        }
        return true;
    }
}
