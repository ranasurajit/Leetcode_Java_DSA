class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(32 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        for (int i = 0; i <= n; i++) { // TC: O(N)
            bitCounts[i] = countSetBits(i); // TC: O(32)
        }
        return bitCounts;
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
