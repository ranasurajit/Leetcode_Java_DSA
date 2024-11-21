class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 1; j < n; j++) { // TC: O(N)
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
