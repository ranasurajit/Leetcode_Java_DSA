class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = Math.max(nums[0], 0); // best answer till index 0
        // best answer till index 1, if index 1 is included index 0 cannot be included
        // dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            int x = nums[i];
            if (i > 1) {
                x += dp[i - 2];
            }
            int y = dp[i - 1];
            dp[i] = Math.max(x, y); // best answer till index i
        }
        return dp[n - 1];
    }
}
