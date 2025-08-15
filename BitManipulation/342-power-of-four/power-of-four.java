class Solution {
    /**
     * Approach II : Using Bit-Manipulation + Bit Masking Approach
     *
     * Intuition : A number is a power of 4 if (n & (n - 1)) == 0
     * and bit is set at its even position from right
     *
     * TC: O(1)
     * SC: O(1)
     */
    public boolean isPowerOfFour(int n) {
        int bitmask = 0x55555555;
        return n > 0 && (n & (n - 1)) == 0 && (n & bitmask) != 0;
    }

    /**
     * Approach I : Using Bit-Manipulation Approach
     *
     * Intuition : A number is a power of 4 if its countSetBits = 1 
     * and that too in its even position
     *
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public boolean isPowerOfFourApproachI(int n) {
        if (n < 4 && n != 1) {
            return false;
        }
        int countSetBits = 0;
        int setBitIndex = -1;
        for (int i = 31; i >= 0; i--) { // TC: O(32)
            if (((n >> i) & 1) == 1) {
                countSetBits++;
                setBitIndex = i;
            }
        }
        return countSetBits == 1 && (setBitIndex & 1) == 0;
    }
}
