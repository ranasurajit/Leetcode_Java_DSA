class Solution {
    /**
     * Using Optimal Approach (Binary Search)
     *
     * TC: O(N + N x log(K)) ~ O(N x log(K))
     * SC: O(1)
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, nums[i]);
        }
        int divisor = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(K)), where K = (high - low)
            int mid = low + (high - low) / 2;
            if (getCalculatedThreshold(nums, n, mid) <= threshold) { // TC: O(N)
                divisor = Math.min(divisor, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return divisor;
    }

    /**
     * Using Brute-Force Approach
     *
     * TC: O(N + K x N) ~ O(K x N)
     * SC: O(1)
     */
    public int smallestDivisorBruteForce(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, nums[i]);
        }
        for (int i = low; i <= high; i++) { // TC: O(K), where K = (high - low)
            if (getCalculatedThreshold(nums, n, i) <= threshold) { // TC: O(N)
                return i;
            }
        }
        return -1;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private int getCalculatedThreshold(int[] nums, int n, int current) {
        int threshold = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int dividend = nums[i] / current;
            threshold += nums[i] % current == 0 ? dividend : (dividend + 1);
        }
        return threshold;
    }
}
