class Solution {
    /**
     * Approach : Using Bit-Manipulation (Brute-Force) Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int singleNumber(int[] nums) {
        /**
         * we know that if we do XOR of same numbers we cancel it to zero
         */
        int xor = 0;
        for (int num : nums) { // TC: O(N)
            xor = xor ^ num;
        }
        return xor;
    }
}
