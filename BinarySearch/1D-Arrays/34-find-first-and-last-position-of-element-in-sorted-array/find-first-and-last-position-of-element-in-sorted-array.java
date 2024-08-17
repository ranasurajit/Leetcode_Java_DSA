class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { searchLeft(nums, target), searchRight(nums, target) };
    }

    public int searchLeft(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int minIndex = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                // nums[mid] == k
                minIndex = mid;
                high = mid - 1;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
    
    public int searchRight(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int maxIndex = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                // nums[mid] == k
                maxIndex = mid;
                low = mid + 1;
            }
        }
        return maxIndex == Integer.MIN_VALUE ? -1 : maxIndex;
    }
}
