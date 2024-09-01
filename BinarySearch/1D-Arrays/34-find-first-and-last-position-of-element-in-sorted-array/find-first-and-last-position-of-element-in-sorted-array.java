class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] positions = { getFirstPosition(nums, target), getLastPosition(nums, target) };
        return positions;
    }

    private int getFirstPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int index = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = Math.min(index, mid);
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }

    private int getLastPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int index = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = Math.max(index, mid);
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return index == Integer.MIN_VALUE ? -1 : index;
    }
}
