class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (22 / 55 testcases passed)
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1]; // states are index and prevIndex
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(0, -1, nums, n, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N x N + N)
     */
    private int solveMemoization(int index, int prevIndex, int[] nums, int n, int[][] memo) {
        // Base Case
        if (index == n) {
            return 0;
        }
        // Memoization Check - shifting of coordinates for prevIndex to accomodate -1 to n
        if (memo[index][prevIndex + 1] != -1) {
            return memo[index][prevIndex + 1];
        }
        // Recursion Calls 
        // Not Take - prevIndex remains same in this case and no contribution to length
        int nottake = 0 + solveMemoization(index + 1, prevIndex, nums, n, memo);
        int take = 0;
        // Take - Check if prevIndex = -1 or nums[index] > nums[prevIndex] for LIS
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
             // Take - prevIndex becomes index and 1 is contributed to length
            take = 1 + solveMemoization(index + 1, index, nums, n, memo);
        }
        return memo[index][prevIndex + 1] = Math.max(take, nottake);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (22 / 55 testcases passed)
     */
    public int lengthOfLISRecursion(int[] nums) {
        int n = nums.length;
        return solveRecursion(0, -1, nums, n);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int index, int prevIndex, int[] nums, int n) {
        // Base Case
        if (index == n) {
            return 0;
        }
        // Recursion Calls 
        // Not Take - prevIndex remains same in this case and no contribution to length
        int nottake = 0 + solveRecursion(index + 1, prevIndex, nums, n);
        int take = 0;
        // Take - Check if prevIndex = -1 or nums[index] > nums[prevIndex] for LIS
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
             // Take - prevIndex becomes index and 1 is contributed to length
            take = 1 + solveRecursion(index + 1, index, nums, n);
        }
        return Math.max(take, nottake);
    }
}
