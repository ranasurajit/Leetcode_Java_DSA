class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     *
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int hammingWeight(int n) {
        int countSetBits = 0;
        for (int i = 31; i >= 0; i--) { // TC: O(32)
            if (((n >> i) & 1) == 1) {
                countSetBits++;
            }
        }
        return countSetBits;
    }
}
