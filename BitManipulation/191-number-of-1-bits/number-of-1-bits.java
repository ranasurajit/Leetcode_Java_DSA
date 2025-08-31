class Solution {
    /**
     * Approach II: Brian Kernighan's Algorithm Approach
     *
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int hammingWeight(int n) {
        int countSetBits = 0;
        while (n > 0) {
            n = (n & (n - 1));
            countSetBits++;
        }
        return countSetBits;
    }
    
    /**
     * Approach I : Using Bit-Manipulation Approach
     *
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int hammingWeightBitManipulation(int n) {
        int countSetBits = 0;
        for (int i = 31; i >= 0; i--) { // TC: O(32)
            if (((n >> i) & 1) == 1) {
                countSetBits++;
            }
        }
        return countSetBits;
    }
}