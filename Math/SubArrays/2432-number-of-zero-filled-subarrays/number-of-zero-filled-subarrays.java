class Solution {
    /**
     * Approach : Using Math Approach
     *
     * Intuition: Keep the streak count of zeros (if nums[i] = 0) 
     * and keep adding it to result if nums[i] != 0 reset the 
     * streak to 0
     *
     * TC: O(N)
     * SC: O(1)
     */
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long result = 0L;
        long streak = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == 0) {
                streak++;
            } else {
                // reset the streak
                streak = 0;
            }
            result += streak;
        }
        return result;
    }
}
