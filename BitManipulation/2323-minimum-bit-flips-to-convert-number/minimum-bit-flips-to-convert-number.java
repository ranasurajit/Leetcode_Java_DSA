class Solution {
    /**
     * Approach II : Using Bit-Manipulation (Better) Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int minBitFlips(int start, int goal) {
        int flip = 0;
        /**
         * we need to find the count of bit difference between start and goal
         * so XOR of start and goal will have bit set when there is a difference
         * so we can count number of set bits in XOR(start, goal)
         */
        int xor = start ^ goal;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            int ithBit = ((xor >> i) & 1);
            if (ithBit == 1) {
                // we need to flip
                flip++;
            }
        }
        return flip;
    }

    /**
     * Approach I : Using Bit-Manipulation Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int minBitFlipsBruteForce(int start, int goal) {
        int flip = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            int siBit = ((start >> i) & 1);
            int giBit = ((goal >> i) & 1);
            if (siBit != giBit) {
                // we need to flip
                flip++;
            }
        }
        return flip;
    }
}
