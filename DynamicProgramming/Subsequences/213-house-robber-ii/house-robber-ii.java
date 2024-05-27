class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                nums2[i - 1] = nums[i]; 
            }
            if (i < n - 1) {
                nums1[i] = nums[i];
            }
        }
        // With recursion
        // return Math.max(maxSumRobbedRecursion(n - 2, nums1), maxSumRobbedRecursion(n - 2, nums2));
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        // With memoization
        // return Math.max(maxSumRobbedMemoization(n - 2, nums1, dp1), 
        //     maxSumRobbedMemoization(n - 2, nums2, dp2));

        // With tabulation
        return Math.max(maxSumRobbedTabulation(nums1, dp1), 
            maxSumRobbedTabulation(nums2, dp2));
    }

    /**
        With Tabulation - TC: O(N), SC: O(N)
     */
    private int maxSumRobbedTabulation(int[] nums, int[] dp) {
        int n = nums.length;
        dp[0] = nums[0];
        for (int i = 0; i < n; i++) {
            // pick
            int pick = nums[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            // not pick
            int notpick = 0;
            if (i > 0) {
                notpick += dp[i - 1];
            }
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n - 1];
    }

    /**
        With Memoization - TC: O(N), SC: O(2N)
     */
    private int maxSumRobbedMemoization(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int pick = nums[index] + maxSumRobbedMemoization(index - 2, nums, dp);
        int notpick = 0 + maxSumRobbedMemoization(index - 1, nums, dp);
        dp[index] = Math.max(pick, notpick);
        return dp[index];
    }

    /**
        With Recursion - TC: O(2^N), SC: O(2^N)
     */
    private int maxSumRobbedRecursion(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        int pick = nums[index] + maxSumRobbedRecursion(index - 2, nums);
        int notpick = 0 + maxSumRobbedRecursion(index - 1, nums);
        return Math.max(pick, notpick);
    }
}
