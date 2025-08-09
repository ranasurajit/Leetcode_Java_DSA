class Solution {
    /**
     * Approach II : Using Bit-Manipulation (Optimal) Approach
     *
     * 16 is a Power of Two - Binary -> 10000
     * 15 -> 01111
     * if we do AND operation 16 & 15 we get 0
     *
     * TC: O(1)
     * SC: O(1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    /**
     * Approach I : Using Bit-Manipulation (Better) Approach
     *
     * 16 is a Power of Two - Binary -> 10000
     * 32 is a Power of Two - Binary -> 100000
     * 1048576 is a Power of Two - Binary -> 100000000000000000000
     *
     * so it has exactly 1 set bit
     *
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public boolean isPowerOfTwoBetterApproach(int n) {
        if (n <= 0) {
            return false;
        }
        int countSetBits = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32) ~ O(1)
            if (((n >> i) & 1) == 1) {
                countSetBits++;
            }
        }
        return countSetBits == 1;
    }
}
