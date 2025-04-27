class Solution {
    /**
     * Approach I : Using Offset Method
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 2; i < n; i++) { // TC: O(N)
            if (2 * (nums[i] + nums[i - 2]) == nums[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
