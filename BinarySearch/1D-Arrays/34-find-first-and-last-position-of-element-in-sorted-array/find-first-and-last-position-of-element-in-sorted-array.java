class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { findLeftMost(nums, target), findRightMost(nums, target) };
        return result;
    }

    private int findLeftMost(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int leftMost = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                leftMost = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return leftMost;
    }

    private int findRightMost(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int rightMost = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                rightMost = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return rightMost;
    }
}
