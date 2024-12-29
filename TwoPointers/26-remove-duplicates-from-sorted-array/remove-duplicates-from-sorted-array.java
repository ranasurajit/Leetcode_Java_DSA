class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0; // pointer at 0th index of nums
        int j = 1; // pointer at 1st index of nums
        while (j < n) { // TC: O(N)
            // we will have only index 'i' pointing to uniques
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1; // number of unique elements
    }
}
