class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x S) + O(N)
     * SC: O(N x S) + O(N)
     *
     * Accepted (147 / 147 testcases passed)
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) { // TC: O(N)
            sum += num;
        }
        if ((sum & 1) != 0) {
            // for odd sum, we cannot partition array into two equal sum subsets
            return false;
        }
        // now the problem is reduced to checking if the array has a subset sum of target = sum / 2
        int target = sum / 2;
        int[][] memo = new int[n + 1][target + 1]; // SC: O(N x S)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(n - 1, nums, target, memo); // TC: O(N x S), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x S)
     * SC: O(N)
     */
    private boolean solveMemoization(int idx, int[] nums, int target, int[][] memo) {
        // Base Case
        if (target == 0) {
            return true;
        }
        if (idx < 0) {
            return false;
        }
        // Memoization Check
        if (memo[idx][target] != -1) {
            return memo[idx][target] == 1;
        }
        // Recursion Calls
        boolean take = false;
        boolean skip = false;
        if (nums[idx] <= target) {
            // we have an option to take or skip
            take = solveMemoization(idx - 1, nums, target - nums[idx], memo);
            skip = solveMemoization(idx - 1, nums, target, memo);
        } else {
            // we cannot take nums[idx] at all
            skip = solveMemoization(idx - 1, nums, target, memo);
        }
        boolean result = take || skip;
        memo[idx][target] = result ? 1 : 0;
        return result;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (39 / 147 testcases passed)
     */
    public boolean canPartitionRecursion(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            // for odd sum, we cannot partition array into two equal sum subsets
            return false;
        }
        // now the problem is reduced to checking if the array has a subset sum of target = sum / 2
        int target = sum / 2;
        return solveRecursion(n - 1, nums, target);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private boolean solveRecursion(int idx, int[] nums, int target) {
        // Base Case
        if (target == 0) {
            return true;
        }
        if (idx < 0) {
            return false;
        }
        // Recursion Calls
        boolean take = false;
        boolean skip = false;
        if (nums[idx] <= target) {
            // we have an option to take or skip
            take = solveRecursion(idx - 1, nums, target - nums[idx]);
            skip = solveRecursion(idx - 1, nums, target);
        } else {
            // we cannot take nums[idx] at all
            skip = solveRecursion(idx - 1, nums, target);
        }
        return take || skip;
    }
}
