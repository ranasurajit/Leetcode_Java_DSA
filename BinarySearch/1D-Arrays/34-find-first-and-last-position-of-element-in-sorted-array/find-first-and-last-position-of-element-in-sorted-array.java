class Solution {
    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[] { searchMinRange(nums, target), searchMaxRange(nums, target) };
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int searchMinRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minRange = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // nums[mid] = target
                minRange = mid;
                high = mid - 1;
            }
        }
        return minRange;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int searchMaxRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int maxRange = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // nums[mid] = target
                maxRange = mid;
                low = mid + 1;
            }
        }
        return maxRange;
    }
}
