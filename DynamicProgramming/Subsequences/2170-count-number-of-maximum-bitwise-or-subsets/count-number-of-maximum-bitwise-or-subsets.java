class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x R) + O(N x R) ~ O(N x R)
     * SC: O(N x R) + O(N)
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
        // Using Recursion + Memoization to find the number of subsets that matches maxOR
        // states are idx and currentXOR ranges from (0 to N - 1) and (0 to maxOR)
        int[][] memo = new int[n][maxOR + 1]; // SC: O(N x R)
        for (int[] mem : memo) {  // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(R)
        }
        return solveMemoization(0, n, 0, nums, maxOR, memo); // TC: O(N x R), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x R)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int currentOR, int[] nums, int maxOR, int[][] memo) {
        // Base Case
        if (idx == n) {
            return currentOR == maxOR ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][currentOR] != -1) {
            return memo[idx][currentOR];
        }
        // Recursion Calls
        // we can choose to pick or skip the nums[idx]
        int pick = solveMemoization(idx + 1, n, (currentOR | nums[idx]), nums, maxOR, memo);
        int skip = solveMemoization(idx + 1, n, currentOR, nums, maxOR, memo);
        return memo[idx][currentOR] = pick + skip;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N) + O(N) ~ O(2 ^ N)
     * SC: O(N)
     */
    public int countMaxOrSubsetsRecursion(int[] nums) {
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
