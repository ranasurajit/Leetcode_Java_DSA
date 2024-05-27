class Solution {
    public int rob(int[] nums) {
        // With recursion
        // return getMaxRobbed(nums.length - 1, nums);

        int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // With memoization
        // return getMaxRobbedMemoization(n - 1, nums, dp);

        // With tabulation
        // return getMaxRobbedTabulation(nums, dp);

        // With space optimization
        return getMaxRobbedSpaceOptimization(nums);
    }

    /**
        With Space Optimization
     */
    private int getMaxRobbedSpaceOptimization(int[] nums) {
        int prev2 = 0;
        int prev = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int notpick = 0;
            if (i > 0) {
                notpick = prev;
            }
            int current = Math.max(pick, notpick);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    /**
        With Tabulation
     */
    private int getMaxRobbedTabulation(int[] nums, int[] dp) {
        dp[0] = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int notpick = 0;
            if (i > 0) {
                notpick = dp[i - 1];
            }
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n - 1];
    }

    /**
        With Memoization
     */
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
