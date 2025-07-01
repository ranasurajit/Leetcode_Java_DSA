class Solution {
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (1010 / 1111 testcases passed)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solveRecursion(n - 1, nums, 0, target);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int[] nums, int currentSum, int target) {
        // Base Case
        if (idx < 0) {
            // we are done exhausing all elements from end to start
            return currentSum == target ? 1 : 0;
        }
        // Recursion Calls
        int option1 = solveRecursion(idx - 1, nums, currentSum + nums[idx], target);
        int option2 = solveRecursion(idx - 1, nums, currentSum - nums[idx], target);
        return option1 + option2;
    }
}
