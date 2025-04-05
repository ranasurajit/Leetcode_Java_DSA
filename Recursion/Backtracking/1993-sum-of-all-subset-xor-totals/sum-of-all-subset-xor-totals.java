class Solution {
    /**
     * Approach II : Using Backtracking Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Accepted (48 / 48 testcases passed) - Beats 100%
     */
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int[] xorSums = { 0 };
        int[] currentXORs = { 0 };
        backtrack(0, nums, currentXORs, xorSums);
        return xorSums[0];
    }

    /**
     * Using Backtracking Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void backtrack(int index, int[] nums, int[] currentXORs, int[] xorSums) {
        xorSums[0] += currentXORs[0];
        for (int i = index; i < nums.length; i++) {
            // update
            currentXORs[0] = currentXORs[0] ^ nums[i];
            // explore all possibilities
            backtrack(i + 1, nums, currentXORs, xorSums);
            // undo
            currentXORs[0] = currentXORs[0] ^ nums[i];
        }
    }

    /**
     * Approach I : Using Bit-Manipulation Approach (PowerSet Approach Without Space)
     *
     * TC: O(N x 2 ^ N)
     * SC: O(1)
     *
     * Accepted (48 / 48 testcases passed) - Beats < 40%
     */
    public int subsetXORSumApproachI(int[] nums) {
        int n = nums.length;
        int xorSums = 0;
        for (int i = 0; i < (1 << n); i++) { // TC: O(2 ^ N)
            int subsetXORs = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if ((i & (1 << j)) != 0) {
                    // jth bit is set
                    subsetXORs ^= nums[j];
                }
            }
            xorSums += subsetXORs;
        }
        return xorSums;
    }
}
