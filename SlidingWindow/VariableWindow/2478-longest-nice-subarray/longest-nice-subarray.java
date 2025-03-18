class Solution {
    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int currentLength = 1;
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (isNiceSubArray(nums, i, j)) {
                    currentLength = j - i + 1;
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    private boolean isNiceSubArray(int[] nums, int start, int end) {
        int bitmask = 0;
        for (int i = start; i <= end; i++) {
            if ((bitmask & nums[i]) != 0) {
                return false;
            }
            bitmask = bitmask | nums[i];
        }
        return true;
    }
}
