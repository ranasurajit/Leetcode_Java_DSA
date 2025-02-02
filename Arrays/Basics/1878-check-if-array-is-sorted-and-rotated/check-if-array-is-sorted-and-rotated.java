class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0; // count of peaks in an array
        for (int i = 0; i < n; i++) { // TC: O(N)
            /**
             * if the sorted array is rotated then peak
             * will be attended only once or less
             */
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }
        return peak <= 1;
    }
}
