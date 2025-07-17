class Solution {
    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N x N)
     * SC: O(N x K)
     * 
     * - O(N x K) - dp array memory
     * 
     * Accepted (732 / 732 testcases passed)
     */
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1]; // SC: O(N x K)
        int maxLength = 1; // as minimum length is 1 as every element can form its sequence
        for (int i = 0; i < n; i++) { // TC: O(N)
            Arrays.fill(dp[i], 1);
            for (int j = 0; j < i; j++) { // TC: O(N)
                int mod = (nums[i] + nums[j]) % k;
                if (dp[i][mod] < 1 + dp[j][mod]) {
                    dp[i][mod] = 1 + dp[j][mod];
                }
                maxLength = Math.max(maxLength, dp[i][mod]);
            }
        }
        return maxLength; 
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N x K) + O(N x N x K)
     * SC: O(N x N x K) + O(N)
     * 
     * - O(N x N x K) - memoization array memory
     * - O(N) - recursion stack
     * 
     * Memory Limit Exceeded (712 / 732 testcases passed)
     */
    public int maximumLengthMemoization(int[] nums, int k) {
        int n = nums.length;
        int[][][] memo = new int[n][n + 1][k + 2]; // SC: O(N x N x K)
        for (int[][] mem : memo) { // TC: O(N x N x K)
            for (int[] m : mem) {
                Arrays.fill(m, -1);
            }
        }
        return solveMemoization(0, -1, -1, nums, n, k, memo); // TC: O(N x N x K), SC: O(N)
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x N x K)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int prevIdx, int targetMod, int[] nums,
        int n, int k, int[][][] memo) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Memoization Check - coordinate shift for prevIdx and targetMod
        if (memo[idx][prevIdx + 1][targetMod + 1] != -1) {
            return memo[idx][prevIdx + 1][targetMod + 1];
        }
        // Recursion Calls
        // we can opt to pick or skip
        int skip = solveMemoization(idx + 1, prevIdx, targetMod, nums, n, k, memo);
        int pick = 0;
        if (prevIdx == -1) {
            pick = 1 + solveMemoization(idx + 1, idx, targetMod, nums, n, k, memo);
        } else {
            int mod = (nums[prevIdx] + nums[idx]) % k;
            if (targetMod == -1 || mod == targetMod) {
                pick = 1 + solveMemoization(idx + 1, idx, mod, nums, n, k, memo);
            }
        }
        return memo[idx][prevIdx + 1][targetMod + 1] = Math.max(pick, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (667 / 732 testcases passed)
     */
    public int maximumLengthRecursion(int[] nums, int k) {
        int n = nums.length;
        return solveRecursion(0, -1, -1, nums, n, k); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int prevIdx, int targetMod, int[] nums, int n, int k) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Recursion Calls
        // we can opt to pick or skip
        int skip = solveRecursion(idx + 1, prevIdx, targetMod, nums, n, k);
        int pick = 0;
        if (prevIdx == -1) {
            pick = 1 + solveRecursion(idx + 1, idx, targetMod, nums, n, k);
        } else {
            int mod = (nums[prevIdx] + nums[idx]) % k;
            if (targetMod == -1 || targetMod == mod) {
                pick = 1 + solveRecursion(idx + 1, idx, mod, nums, n, k);
            }
        }
        return Math.max(pick, skip);
    }
}
