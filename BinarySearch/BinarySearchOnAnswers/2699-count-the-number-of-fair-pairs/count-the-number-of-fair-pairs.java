class Solution {
    /**
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);    // TC: O(N x log(N))
        long count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int leftIdx = lowerBound(nums, i + 1, n, lower - nums[i]);  // TC: O(log(N))
            int rightIdx = upperBound(nums, i + 1, n, upper - nums[i]); // TC: O(log(N))
            int x = leftIdx - i - 1;  // x is the count of pairs < lower
            int y = rightIdx - i - 1; // y is the count of pairs <= upper
            // (y - x) gives the count at each index such that lower <= nums[i] + nums[j] <= upper
            count += (y - x);
        }
        return count;
    }

    private int lowerBound(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end - 1;
        int answer = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end - 1;
        int answer = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
