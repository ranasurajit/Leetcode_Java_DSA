class Solution {
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(0, nums, 0, target);
    }

    private int solve(int index, int[] nums, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int positiveSelection = solve(index + 1, nums, sum + nums[index], target);
        int negativeSelection = solve(index + 1, nums, sum - nums[index], target);
        return positiveSelection + negativeSelection; 
    }
}
