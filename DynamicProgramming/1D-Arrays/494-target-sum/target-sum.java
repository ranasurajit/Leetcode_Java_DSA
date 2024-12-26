class Solution {
    /**
     * Using Recursion + Memoization
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int[] dp1D: dp) {
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(0, nums, 0, target, dp);
    }

    private int solveMemoization(int index, int[] nums, int sum, int target, int[][] dp) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int positiveSelection = solveRecursion(index + 1, nums, sum + nums[index], target);
        int negativeSelection = solveRecursion(index + 1, nums, sum - nums[index], target);
        dp[index][sum] = positiveSelection + negativeSelection;
        return dp[index][sum];
    }

    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int findTargetSumWaysRecursion(int[] nums, int target) {
        int n = nums.length;
        return solveRecursion(0, nums, 0, target);
    }

    private int solveRecursion(int index, int[] nums, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int positiveSelection = solveRecursion(index + 1, nums, sum + nums[index], target);
        int negativeSelection = solveRecursion(index + 1, nums, sum - nums[index], target);
        return positiveSelection + negativeSelection; 
    }
}
