class Solution {
    /**
     * Using Property of XOR and using Greedy Algorithm
     *
     * TC: O(1)
     * SC: O(1)
     */
    public int minimizeXor(int num1, int num2) {
        int setBits = 0;
        int result = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32) ~ O(1)
            if (((num2 >> i) & 1) == 1) {
                setBits++;
            }
        }

        // Cancel set bits from highest to lowest significant bit from right to left
        for (int i = 31; i >= 0 && setBits > 0; i--) { // TC: O(32) ~ O(1)
            if (((num1 >> i) & 1) == 1) {
                setBits--;
                result += (1 << i);
            }
        }

        // set the bits starting from lowest significant bit for left over setBits
        for (int i = 0; i < 32 && setBits > 0; i++) { // TC: O(32) ~ O(1)
            if (((num1 >> i) & 1) == 0) {
                setBits--;
                result += (1 << i);
            }
        }
        return result;
    }
}
