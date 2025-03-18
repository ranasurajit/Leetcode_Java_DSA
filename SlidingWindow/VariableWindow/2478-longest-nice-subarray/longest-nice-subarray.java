class Solution {
    /**
     * Approach III : Sliding Window Approach
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Testcases passed (65 / 65) - Runtime 4ms - Beats 28.34%
     */
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int i = 0;
        int j = 0;
        int bitmask = 0;
        while (j < n) { // TC: O(N)
            while ((bitmask & nums[j]) != 0) {
                // remove the previous calculation from nums[i]
                bitmask = bitmask ^ nums[i];
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            bitmask = (bitmask | nums[j]);
            j++;
        }
        return maxLength;
    }

    /**
     * Approach II : Better Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Testcases passed (65 / 65) - Runtime 4ms - Beats 28.34%
     */
    public int longestNiceSubarrayApproachII(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int bitmask = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                if ((bitmask & nums[j]) != 0) {
                    break;
                }
                bitmask = (bitmask | nums[j]);
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     *
     * Testcases passed (65 / 65) - Runtime 7ms - Beats 15.80%
     */
    public int longestNiceSubarrayApproachI(int[] nums) {
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
