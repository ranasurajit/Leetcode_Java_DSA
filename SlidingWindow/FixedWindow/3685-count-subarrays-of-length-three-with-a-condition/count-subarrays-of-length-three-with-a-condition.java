class Solution {
    /**
     * Approach II : Using Sliding Window (Fixed Size) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        while (j < n) { // TC: O(N)
            if (j - i + 1 < 3) {
                j++;
            } else {
                // window size is 3 here
                if (2 * (nums[i] + nums[j]) == nums[i + 1]) {
                    count++;
                }
                // maintain the size and move to next window
                i++;
                j++;
            }
        }
        return count;
    }

    /**
     * Approach I : Using Index Offset Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int countSubarraysApproachI(int[] nums) {
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
