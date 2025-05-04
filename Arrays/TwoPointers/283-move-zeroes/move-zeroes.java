class Solution {
    /**
     * Approach I : Using Two Pass Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < n) { // TC: O(N)
            nums[index++] = 0;
        }
    }
}
