class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n-1] != nums[n -2]) {
            return nums[n - 1];
        }
        int low = 2;
        int high = n - 3;
        // the duplicate elements starts at even position unless sequence is broken by a single element
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid - 1]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                // even single element will fall here
                if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                }
                low = mid + 2;
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
