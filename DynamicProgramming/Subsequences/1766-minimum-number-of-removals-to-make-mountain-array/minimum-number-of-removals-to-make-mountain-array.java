class Solution {
    /**
     * TC: O(2 x N x N + N) ~ O(N x N)
     * SC: O(2N) ~ O(N)
     */
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];  // SC: O(N)
        int[] right = new int[n]; // SC: O(N)
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // finding longest increasing sequence from left to right
        for (int i = 0; i < n; i++) { // TC: O(N x N)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], 1 + left[j]);
                }
            }
        }
        // finding longest decreasing sequence from right to left
        for (int i = n - 1; i >= 0; i--) { // TC: O(N x N)
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], 1 + right[j]);
                }
            }
        }
        int removals = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (left[i] > 1 && right[i] > 1) {
                removals = Math.min(removals, n - (left[i] + right[i] - 1));
            }
        }
        return removals;
    }
}
