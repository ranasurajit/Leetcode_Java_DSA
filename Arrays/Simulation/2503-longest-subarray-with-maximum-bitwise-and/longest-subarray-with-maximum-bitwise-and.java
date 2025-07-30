class Solution {
    /**
     * Approach : Using Array Simulation
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(1)
     *
     * Note: We cannot use sliding window here as in AND operation
     * we cannot recover B when we do (A & B) by doing A ^ (A & B) != B
     */
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        /**
         * whenever we do AND operation, the value always reduces than any
         * higher value within an array so maximum Bitwise AND of the array
         * is definitely its maximum value 
         */
        int maxAND = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxAND = Math.max(maxAND, nums[i]);
        }
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == maxAND) {
                currentLength++;
            } else {
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
