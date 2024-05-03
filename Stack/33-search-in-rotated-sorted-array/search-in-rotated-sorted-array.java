class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // case 1: if target equals mid element
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[low]) { // case 2: if left part is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1; // eleminate right part
                } else {
                    low = mid + 1; // eleminate left part
                }
            } else { // case 3: if right part is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1; // eleminate left part
                } else {
                    high = mid - 1; // eleminate right part
                }
            }
        }
        return -1;
    }
}
