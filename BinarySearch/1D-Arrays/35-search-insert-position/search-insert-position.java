class Solution {
    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        return lowerbound(nums, target);
    }

    /**
     * Lower bound => nums[i] >= x
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int lowerbound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
