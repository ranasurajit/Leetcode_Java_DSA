class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     *
     * TC: O(N x T + N) ~ O(N x T)
     * SC: O(2 x T) ~ O(T)
     *
     * Accepted (144 / 144 testcases passed), Beats 60.78%, Memory 76.62%
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalSum += nums[i];
        }
        // If sum is odd then it is not possible to form two subsets
        if ((totalSum & 1) != 0) {
            return false;
        }
        /**
         * Now the problem is reduced to find a subset with sum = totalSum / 2.
         * Two subsets should have totalSum = sum / 2
         */
        int sum = totalSum / 2;
        // Initialization
        boolean[] prev = new boolean[sum + 1]; // TC: O(T)
        prev[0] = true;
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            boolean[] current = new boolean[sum + 1]; // TC: O(T)
            current[0] = true;
            for (int j = 1; j < sum + 1; j++) { // TC: O(T)
                if (j >= nums[i - 1]) {
                    current[j] = prev[j - nums[i - 1]] || prev[j];
                } else {
                    current[j] = prev[j];
                }
            }
            prev = current;
        }
        return prev[sum];
    }

    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(N x T + 2 x N + T) ~ O(N x T)
     * SC: O(N x T)
     *
     * Accepted (144 / 144 testcases passed), Beats 51.31%, Memory 65.70%
     */
    public boolean canPartitionTabulation(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalSum += nums[i];
        }
        // If sum is odd then it is not possible to form two subsets
        if ((totalSum & 1) != 0) {
            return false;
        }
        /**
         * Now the problem is reduced to find a subset with sum = totalSum / 2.
         * Two subsets should have totalSum = sum / 2
         */
        int sum = totalSum / 2;
        // Initialization
        boolean[][] dp = new boolean[n + 1][sum + 1]; // SC: O(N x T)
        for (int j = 0; j < sum + 1; j++) { // TC: O(T)
            dp[0][j] = false;
        }
        for (int i = 0; i < n + 1; i++) { // TC: O(N)
            dp[i][0] = true;
        }
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 1; j < sum + 1; j++) { // TC: O(T)
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N x T + N) ~ O(N x T)
     * SC: O(N x T + N)
     *
     * Accepted (144 / 144 testcases passed), Beats 93.79%, Memory 40.15%
     */
    public boolean canPartitionMemoization(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalSum += nums[i];
        }
        // If sum is odd then it is not possible to form two subsets
        if ((totalSum & 1) != 0) {
            return false;
        }
        /**
         * Now the problem is reduced to find a subset with sum = totalSum / 2.
         * Two subsets should have totalSum = sum / 2
         */
        int sum = totalSum / 2;
        int[][] memo = new int[n + 1][sum + 1]; // SC: O(N x T)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(n, sum, nums, memo); // TC: O(N x T), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x T)
     * SC: O(N)
     */
    private boolean solveMemoization(int n, int sum, int[] nums, int[][] memo) {
        // Base Case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Memoization Check
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }
        // Recursion Calls
        // take or not take
        if (sum >= nums[n - 1]) {
            // we have option to pick or not pick
            boolean result = solveMemoization(n - 1, sum - nums[n - 1], nums, memo) ||
                solveMemoization(n - 1, sum, nums, memo);
            memo[n][sum] = result ? 1 : 0;
            return result;
        } else {
            // we cannot pick
            boolean result = solveMemoization(n - 1, sum, nums, memo);
            memo[n][sum] = result ? 1 : 0;
            return result;
        }
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N + 2 ^ N) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (37 / 144 testcases passed)
     */
    public boolean canPartitionRecursion(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalSum += nums[i];
        }
        // If sum is odd then it is not possible to form two subsets
        if ((totalSum & 1) != 0) {
            return false;
        }
        /**
         * Now the problem is reduced to find a subset with sum = totalSum / 2.
         * Two subsets should have totalSum = sum / 2
         */
        int sum = totalSum / 2;
        return solveRecursion(n, sum, nums); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private boolean solveRecursion(int n, int sum, int[] nums) {
        // Base Case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Recursion Calls
        // take or not take
        if (sum >= nums[n - 1]) {
            // we have option to pick or not pick
            return solveRecursion(n - 1, sum - nums[n - 1], nums) ||
                solveRecursion(n - 1, sum, nums);
        } else {
            // we cannot pick
            return solveRecursion(n - 1, sum, nums);
        }
    }
}
