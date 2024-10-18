class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ormax = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            ormax = (ormax | nums[i]);
        }
        int[][] dp = new int[n + 1][ormax + 1];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        int count = solve(0, nums, 0, ormax, dp);
        return count;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solve(int index, int[] nums, int cor, int max, int[][] dp) {
        // Base case
        if (index == nums.length) {
            if (cor == max) {
                return 1;
            }
            return 0;
        }
        if (dp[index][cor] != -1) {
            return dp[index][cor];
        }
        // take
        int take = solve(index + 1, nums, (cor | nums[index]), max, dp);
        // not take
        int nottake = solve(index + 1, nums, cor, max, dp);
        dp[index][cor] = take + nottake;
        return dp[index][cor];
    }
}
