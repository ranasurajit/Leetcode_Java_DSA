class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        int countSetBits = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            int ithBit = ((n >> i) & 1);
            if (ithBit == 1) {
                countSetBits++;
            }
        }
        // for a number to be power of 2 it should have exactly 1 set bit
        return countSetBits == 1;
    }
}
