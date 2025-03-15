class Solution {
    /**
     * Approach V : Optimal Approach (Using Binary Search on Answers Technique)
     *
     * TC: O(N + N x log(K))
     * SC: O(1)
     *
     *  where K = Max(nums) - Min(nums)
     */
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        // Applying Binary Search
        int result = 0;
        while (low <= high) { // TC: O(log(K)), where K = Max(nums) - Min(nums)
            int mid = low + (high - low) / 2;
            if (isMaxCapabilityPossible(nums, k, mid, n)) { // TC: O(N)
                result = mid;
                high = mid - 1; // as we need to minimize the capability
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * We need not check for every index for starting index as it says: 
     * `It is always possible to steal at least k houses.`
     *
     * TC: O(N)
     * SC: O(1)
     */
    private boolean isMaxCapabilityPossible(int[] nums, int k, int mid, int n) {
        int countHouses = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] <= mid) {
                countHouses++;
                i++; // skip adjacent houses
            }
        }
        return countHouses >= k;
    }

    /**
     * Approach IV : Better Approach (Using Space Optimization)
     *
     * TC: O(N x K)
     * SC: O(3 x K) ~ O(K)
     *
     * (53 / 64 testcases passed) - (Fails as TC goes 10^5 x 10^5 ~ 10^10 ~ 100 sec to run)
     */
    public int minCapabilitySpaceOptimization(int[] nums, int k) {
        int n = nums.length;
        // Initialization
        int[] prev2 = new int[k + 1];
        Arrays.fill(prev2, Integer.MAX_VALUE);
        prev2[0] = 0;
        int[] prev = new int[k + 1];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[0] = 0;
        // Iterative Calls - convert dp[i] as current and dp[i - 1] as prev
        for (int i = 1; i < n + 1; i++) {
            int[] current = new int[k + 1];
            current[0] = 0;
            for (int j = 1; j < k + 1; j++) {
                // not take
                current[j] = prev[j];
                // take
                if (i >= 2) {
                    current[j] = Math.min(current[j], Math.max(nums[i - 1], prev2[j - 1]));
                } else if (j == 1) {
                    current[j] = Math.min(current[j], nums[i - 1]);
                }
            }
            prev2 = prev.clone();
            prev = current.clone();
        }
        return prev[k];
    }

    /**
     * Approach III : Better Approach (Using Tabulation)
     *
     * TC: O(N x K)
     * SC: O(N x K)
     *
     * (52 / 64 testcases passed) - (Fails as TC goes 10^5 x 10^5 ~ 10^10 ~ 100 sec to run)
     */
    public int minCapabilityTabulation(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        // Initialization
        for (int j = 1; j < k + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        // Iterative Calls - convert (n, k) as (i , j)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                // not take
                dp[i][j] = dp[i - 1][j];
                // take
                if (i >= 2) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(nums[i - 1], dp[i - 2][j - 1]));
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i][j], nums[i - 1]);
                }
            }
        }
        return dp[n][k];
    }

    /**
     * Approach II : Better Approach (Using Memoization)
     *
     * TC: O(N x K)
     * SC: O(N x K + N)
     *
     * (52 / 64 testcases passed)
     */
    public int minCapabilityMemoization(int[] nums, int k) {
        int n = nums.length;
        int[][] memo = new int[n + 1][k + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(n, nums, k, memo);
    }

    /**
     * Using Memoization
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int [] nums, int k, int[][] memo) {
        // Base Case
        if (k == 0) {
            return 0;
        }
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        // Memoization Check
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        // Recursion Calls
        // take
        int take = Math.max(nums[n - 1], solveMemoization(n - 2, nums, k - 1, memo));
        // not take
        int nottake = solveMemoization(n - 1, nums, k, memo);
        return memo[n][k] = Math.min(take, nottake);
    }

    /**
     * Approach I : Brute-Force Approach (Using Recursion)
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * (28 / 64 testcases passed)
     */
    public int minCapabilityRecursion(int[] nums, int k) {
        int n = nums.length;
        return solveRecursion(n, nums, k);
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int [] nums, int k) {
        // Base Case
        if (k == 0) {
            return 0;
        }
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        // Recursion Calls
        // take
        int take = Math.max(nums[n - 1], solveRecursion(n - 2, nums, k - 1));
        // not take
        int nottake = solveRecursion(n - 1, nums, k);
        return Math.min(take, nottake);
    }
}
