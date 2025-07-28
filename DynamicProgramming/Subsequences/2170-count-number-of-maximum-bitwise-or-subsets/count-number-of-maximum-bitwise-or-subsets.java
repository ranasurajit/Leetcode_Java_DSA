class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N) + O(N) ~ O(2 ^ N)
     * SC: O(N)
     */
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        /**
         * maximum possible bitwise OR of nums will be bitwise OR of all elements
         */
        int maxOR = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxOR |= nums[i];
        }
        // Using Recursion to find the number of subsets that matches maxOR
        return solveRecursion(0, n, 0, nums, maxOR); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, int currentOR, int[] nums, int maxOR) {
        // Base Case
        if (idx == n) {
            return currentOR == maxOR ? 1 : 0;
        }
        // Recursion Calls
        // we can choose to pick or skip the nums[idx]
        int pick = solveRecursion(idx + 1, n, (currentOR | nums[idx]), nums, maxOR);
        int skip = solveRecursion(idx + 1, n, currentOR, nums, maxOR);
        return pick + skip;
    }
}
