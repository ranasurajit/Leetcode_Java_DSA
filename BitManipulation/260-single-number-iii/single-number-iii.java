class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     *
     * TC: O(2 x N)
     * SC: O(1)
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int item : nums) { // TC: O(N)
            xor ^= item;
        }
        // find the right most set bit
        int rightMostSetBit = xor & -xor;
        int first = 0;
        int second = 0;
        for (int item : nums) { // TC: O(N)
            if ((rightMostSetBit & item)== 0) {
                first ^= item;
            } else {
                second ^= item;
            }
        }
        return new int[] { first, second };
    }
}
