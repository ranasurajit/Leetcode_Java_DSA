class Solution {
    /**
     * Approach I : Using Backtracking Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
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
}
