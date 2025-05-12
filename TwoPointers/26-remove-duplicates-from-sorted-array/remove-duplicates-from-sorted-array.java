class Solution {
    /**
     * Approach : Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 0; // points to unique element
        int q = 1; // finds the unique element
        while (q < n) { // TC: O(N)
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
                q++;
            } else {
                q++;
            }
        }
        return p + 1;
    }
}
