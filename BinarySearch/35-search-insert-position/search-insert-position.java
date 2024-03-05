class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[high]) {
            return n;
        }
        int index = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
                index = Math.min(index, mid);
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}