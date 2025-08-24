class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int count0s = 0;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int maxLength = 0;
        while (j < n) { // TC: O(N)
            count0s += (nums[j] == 0) ? 1 : 0;
            while (count0s > 1) {
                // remove computation from index 'i'
                count0s -= (nums[i] == 0) ? 1 : 0;
                i++;
            }
            if (count0s <= 1) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength - 1;
    }
}
