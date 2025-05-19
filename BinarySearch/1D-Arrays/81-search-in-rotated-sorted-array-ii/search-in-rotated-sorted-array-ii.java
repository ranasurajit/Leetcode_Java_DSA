class Solution {
    /**
     * Approach : Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            // eliminating duplicates at left
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            // eliminating duplicates at right
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= nums[low]) {
                // left part is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    // target lies in left
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) {
                // right part is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    // target lies in right
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
