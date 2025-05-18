class Solution {
    /**
     * Approach : Using Binary Search
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // search space is after mid index
                low = mid + 1;
            } else {
                // search space is before mid index
                high = mid - 1;
            }
        }
        return -1;
    }
}
