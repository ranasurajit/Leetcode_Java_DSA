class Solution {
    public int minBitFlips(int start, int goal) {
        /** 
         * the number of bit flips needed can be found by doing XOR of 
         * start and goal then it would be having set bits 1 for whichever
         * bit is different for start and goal numbers
         */
        int result = start ^ goal;
        int count1Bits = 0;
        // in all 32 bits get the count of each set (1) bit
        for (int i = 0; i < 32; i++) {
            if ((result & 1) == 1) {
                count1Bits++;
            }
            // removing bits to right to check if last bit is set
            result = result >> 1;
        }
        return count1Bits;
    }
}
