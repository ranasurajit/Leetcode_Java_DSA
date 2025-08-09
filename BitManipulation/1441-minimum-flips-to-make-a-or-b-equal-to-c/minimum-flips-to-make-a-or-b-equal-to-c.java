class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 31; i >= 0; i--) { // TC: O(32)
            int aiBit = ((a >> i) & 1);
            int biBit = ((b >> i) & 1);
            int ciBit = ((c >> i) & 1);
            if ((aiBit | biBit) == ciBit) {
                continue;
            }
            if (ciBit == 0) {
                if (aiBit != 0) {
                    flips++;
                }
                if (biBit != 0) {
                    flips++;
                }
            } else {
                if (aiBit != 1 || biBit != 1) {
                    flips++;
                }
            }
        }
        return flips++;
    }
}
