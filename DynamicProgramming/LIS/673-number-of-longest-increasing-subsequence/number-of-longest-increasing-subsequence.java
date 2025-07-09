class Solution {
    /**
     * Approach : Using Tabulation (Bottom-Up DP) + Optimized Approach
     * 
     * TC: O(N x N) + O(N) ~ O(N x N)
     * SC: O(N) + O(N)
     * 
     * - O(N) - dp and count array memory
     *
     * Accepted (55 / 55 testcases passed)
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];    // SC: O(N)
        // we will be counting the number of LIS in this array
        int[] count = new int[n]; // SC: O(N)
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            for (int prevIdx = 0; prevIdx < i; prevIdx++) { // TC: O(N)
                if (nums[i] > nums[prevIdx] && dp[prevIdx] + 1 > dp[i]) {
                    dp[i] = dp[prevIdx] + 1;
                    count[i] = count[prevIdx];
                } else if (nums[i] > nums[prevIdx] && dp[prevIdx] + 1 == dp[i]) {
                    count[i] += count[prevIdx];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (dp[i] == maxLength) {
                result += count[i];
            }
        }
        return result;
    }
}
