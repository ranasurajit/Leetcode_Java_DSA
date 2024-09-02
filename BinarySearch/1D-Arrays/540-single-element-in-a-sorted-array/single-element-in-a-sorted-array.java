class Solution {

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 2] != nums[n - 1]) {
            return nums[n - 1];
        }
        int low = 2;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid - 1]) {
                mid = mid - 1;
            }
            /**
                * Non-repeating element would be found in even index only
                * any duplicate elements starts from even index unless single
                * element breaks this. After single element, the repeating 
                * element starts from odd index
                */
            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                } else {
                    low = mid + 2;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
