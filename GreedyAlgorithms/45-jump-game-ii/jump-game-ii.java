class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N)
     * SC: O(N x N) + O(N)
     * 
     * - O(N x N) - memoization array memory
     * - O(N) - recursion stack
     * 
     * Accepted (110 / 110 testcases passed)
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n]; // SC: O(N)
        Arrays.fill(memo, -1);
        return solveMemoization(0, n, nums, memo); // TC: O(N x N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int[] nums, int[] memo) {
        // Base Case
        if (idx >= n - 1) {
            return 0;
        }
        // Memoization Check
        if (memo[idx] != -1) {
            return memo[idx];
        }
        // Recursion Calls
        int jumps = nums[idx];
        int minJumps = n;
        for (int i = 1; i <= jumps; i++) { // TC: O(N)
            if (idx + i < n) {
                minJumps = Math.min(minJumps, 1 + solveMemoization(idx + i, n, nums, memo));
            }
        }
        return memo[idx] = minJumps;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (74 / 110 testcases passed)
     */
    public int jumpRecursion(int[] nums) {
        int n = nums.length;
        return solveRecursion(0, n, nums); // TC: O(N x 2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, int[] nums) {
        // Base Case
        if (idx >= n - 1) {
            return 0;
        }
        // Recursion Calls
        int jumps = nums[idx];
        int minJumps = n;
        for (int i = 1; i <= jumps; i++) { // TC: O(N)
            if (idx + i < n) {
                minJumps = Math.min(minJumps, 1 + solveRecursion(idx + i, n, nums));
            }
        }
        return minJumps;
    }
}
