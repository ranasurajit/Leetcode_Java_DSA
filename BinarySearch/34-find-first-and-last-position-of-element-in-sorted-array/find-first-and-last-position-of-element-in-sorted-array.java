class Solution {
    /**
     * TC: O(2log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ getFirstPosition(nums, target), getLastPosition(nums, target) };
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private int getFirstPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private int getLastPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int maxIndex = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                maxIndex = Math.max(maxIndex, mid);
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxIndex == Integer.MIN_VALUE ? -1 : maxIndex;
    }
}
