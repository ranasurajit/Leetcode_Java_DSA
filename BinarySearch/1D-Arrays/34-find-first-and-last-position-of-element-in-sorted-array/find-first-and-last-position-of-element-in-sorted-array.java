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
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int lBound = lowerBound(nums, target);
        if (lBound == -1) {
            return new int[] { -1, -1 };
        }
        int rBound = upperBound(nums, target);
        return new int[] {
            lBound,
            rBound - 1
        };
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * Lower Bound => nums[i] >= target
     * 
     * @param nums
     * @param target
     * @return
     */
    private int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low >= n || nums[low] != target) {
            return -1;
        }
        return low;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * Upper Bound => nums[i] > target
     * 
     * @param nums
     * @param target
     * @return
     */
    private int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRangeWithoutBound(int[] nums, int target) {
        return new int[] {
            searchMinRange(nums, target),
            searchMaxRange(nums, target)
        };
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
