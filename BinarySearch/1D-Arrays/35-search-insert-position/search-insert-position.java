class Solution {
    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int pos = Integer.MAX_VALUE;
        if (nums[0] > target) {
            return 0;
        }
        if (nums[n - 1] < target) {
            return n;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                pos = Math.min(pos, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }
}
