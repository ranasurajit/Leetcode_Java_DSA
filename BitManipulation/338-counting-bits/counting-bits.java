class Solution {
    /**
     * Approach II : Using Bit-Manipulation (Optimal) Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        // bitCounts in i = 0 = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            /**
             * if i = even, then number of set bits in i = number of set bits in (i / 2)
             * if i = odd, then number of set bits int i = number of set bits in (i - 1) + 1
             * (as i - 1 is even and we add 1 to (i - 1) to form i)
             */
            bitCounts[i] = (i & 1) == 0 ? bitCounts[i / 2] : bitCounts[i - 1] + 1;
        }
        return bitCounts;
    }

    /**
     * Using Bit-Manipulation Approach
     * 
     * TC: O(32)
     * SC: O(1)
     */
    private int countSetBitsBruteForce(int p) {
        int count = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            if (((p >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Using Bit-Manipulation Approach
     * 
     * TC: O(32)
     * SC: O(1)
     */
    private int countSetBits(int p) {
        int count = 0;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            if (((p >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
