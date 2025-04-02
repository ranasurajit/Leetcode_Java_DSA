class Solution {
    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 3; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    maxValue = Math.max(maxValue, (nums[i] - nums[j]) * (long) nums[k]);
                }
            }
        }
        return maxValue < 0 ? 0 : maxValue;
    }
}
