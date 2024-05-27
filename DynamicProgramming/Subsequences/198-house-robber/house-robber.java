class Solution {
    public int rob(int[] nums) {
        // With recursion
        // return getMaxRobbed(nums.length - 1, nums);

        // With memoization
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMaxRobbedMemoization(n - 1, nums, dp);
    }

    private int getMaxRobbedMemoization(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        // pick
        int pick = nums[index] + getMaxRobbedMemoization(index - 2, nums, dp);
        // not pick
        int notpick = 0 + getMaxRobbedMemoization(index - 1, nums, dp);
        // return the maximum sum
        dp[index] = Math.max(pick, notpick);
        return dp[index];
    }

    /**
        With Recursion
     */
    private int getMaxRobbed(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        // pick
        int pick = nums[index] + getMaxRobbed(index - 2, nums);
        // not pick
        int notpick = 0 + getMaxRobbed(index - 1, nums);
        // return the maximum sum
        return Math.max(pick, notpick);
    }
}
