class Solution {
    /**
     * Approach : Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int low = 1;
        int high = n - 2;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                // this is a peak, so return mid
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                // peak lies to the right of mid
                low = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                // peak lies to the left of mid
                high = mid - 1;
            }
        }
        return -1;
    }
}
