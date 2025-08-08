class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int minBitFlips(int start, int goal) {
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
