class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        int streak = 0;
        int result = 0;
        /**
         * bitwise AND of any two numbers cannot exceed the max of two
         * so we need to find the maximum number and maximum length of
         * contiguous occurence of max number
         */
        for (int num : nums) {
            if (max < num) {
                max = num;
                streak = 0;
                result = 0;
            }
            if (num == max) {
                streak++;
            } else {
                streak = 0;
            }
            result = Math.max(result, streak);
        }
        return result;
    }
}
