class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int item : nums) { // TC: O(N)
            result ^= item;
        }
        return result;
    }
}
