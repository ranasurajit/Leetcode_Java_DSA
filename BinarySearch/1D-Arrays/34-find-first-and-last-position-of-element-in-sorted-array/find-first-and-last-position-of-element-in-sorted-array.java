class Solution {
    /**
     * Approach : Using Binary Search Approach
     *
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[] { -1, -1 };
        }
        int lBound = lowerBound(nums, n, target); // TC: O(log(N))
        if (lBound == n || nums[lBound] != target) {
            return new int[] { -1, -1 };
        }
        int uBound = upperBound(nums, n, target); // TC: O(log(N))
        return new int[] {
            lBound,
            uBound - 1
        };
    }

    /**
     * Using Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    int lowerBound(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Using Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    int upperBound(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
