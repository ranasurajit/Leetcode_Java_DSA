class Solution {
    /**
     * Approach I : Using Binary Search Approach (Finding MinIndex or Rotated Index)
     * 
     * TC: O(log(N) + log(L) + log(N - L))
     * SC: O(1)
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minIndex = getRotatedIndex(nums, n); // TC: O(log(N))
        // index [0...minIndex - 1] is sorted so target may lie in this range
        int searchIndexLeft = searchTarget(nums, 0, minIndex - 1, target); // TC: O(log(L))
        // index [minIndex...n] is sorted so target may lie in this range
        int searchIndexRight = searchTarget(nums, minIndex, n - 1, target); // TC: O(log(N - L))
        if (searchIndexLeft == -1) {
            return searchIndexRight;
        } else {
            return searchIndexLeft;
        }
    }

    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(H - L))
     * SC: O(1)
     */
    private int searchTarget(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // target lies in left part
                high = mid - 1;
            } else {
                // target lies in right part
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int getRotatedIndex(int[] nums, int n) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                // array 'nums' is sorted and 0 times rotated
                return low;
            }
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                // minimum value found
                return mid;
            } else if (nums[mid] >= nums[low]) {
                // left part is sorted so, minimum value lies in right portion
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                // right part is sorted so, minimum value lies in left portion
                high = mid - 1;
            }
        }
        return 0;
    }
}
