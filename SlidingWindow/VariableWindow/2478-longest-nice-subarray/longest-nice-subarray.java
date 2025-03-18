class Solution {
    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                if (isNiceSubArray(nums, i, j)) { // TC: O(N)
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private boolean isNiceSubArray(int[] nums, int start, int end) {
        int bitmask = 0;
        for (int i = start; i <= end; i++) { // TC: O(K) where K = N in worst case
            if ((bitmask & nums[i]) != 0) {
                return false;
            }
            bitmask = bitmask | nums[i];
        }
        return true;
    }
}
