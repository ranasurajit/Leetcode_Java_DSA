class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x S) + O(N)
     * SC: O(N x S) + O(N)
     *
     * Accepted (1111 / 1111 testcases passed)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) { // TC: O(N)
            totalSum += num;
        }
        if (Math.abs(target) > totalSum) {
            // impossible to have target sum
            return 0;
        }
        // sum can range in [-totalSum, totalSum] so we need to offset the memoized array
        int[][] memo = new int[n + 1][totalSum * 2 + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(n - 1, nums, 0, target, memo, totalSum);
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x S)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int[] nums, int currentSum, int target, 
        int[][] memo, int offset) {
        // Base Case
        if (idx < 0) {
            // we are done exhausing all elements from end to start
            return currentSum == target ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][currentSum + offset] != -1) {
            return memo[idx][currentSum + offset];
        }
        // Recursion Calls
        int option1 = solveMemoization(idx - 1, nums, currentSum + nums[idx], target, memo, offset);
        int option2 = solveMemoization(idx - 1, nums, currentSum - nums[idx], target, memo, offset);
        return memo[idx][currentSum + offset] = option1 + option2;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (141 / 141 testcases passed)
     */
    public int findTargetSumWaysRecursion(int[] nums, int target) {
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
