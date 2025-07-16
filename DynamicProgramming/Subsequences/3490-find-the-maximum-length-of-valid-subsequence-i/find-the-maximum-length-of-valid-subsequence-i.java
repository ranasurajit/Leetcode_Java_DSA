class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     *
     * Accepted (951 / 951 testcases passed)
     */
    public int maximumLength(int[] nums) {
        int n = nums.length;
        /**
         * To satisfy the condition: 
         * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2,
         * we need to have sub-sequences with 
         * 1. (even + even) + (even + even) .... or,
         * 2. (odd + odd) + (odd + odd) .....    or,
         * 3. (odd + even) + (odd + even) ... (odd <--> even is swapable)
         *
         * so we need to achieve a parity check
         */
        int maxLength = Integer.MIN_VALUE;
        int[][][] memo = new int[n][2][2]; // SC: O(N x 2 x 2) ~ O(N)
        for (int[][] mem : memo) {  // TC: O(N)
            for(int[] m : mem) {    // TC: O(2)
                Arrays.fill(m, -1); // TC: O(2)
            }
        }
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            maxLength = Math.max(maxLength, 
                1 + solveMemoization(i + 1, nums[i] % 2, 0, nums, memo)); // TC: O(N), SC: O(N)
            maxLength = Math.max(maxLength,
                1 + solveMemoization(i + 1, nums[i] % 2, 1, nums, memo)); // TC: O(N), SC: O(N)
        }
        return maxLength;
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x 2 x 2) ~ O(N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int prevParity, int targetParity, int[] nums, int[][][] memo) {
        // Base Case
        if (idx == nums.length) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][prevParity][targetParity] != -1) {
            return memo[idx][prevParity][targetParity];
        }
        // Recursion Calls
        /**
         * If targetParity is 0 (even) so we need to have 
         * 1. prevParity = 0 and currentParity = 0 or
         * 2. prevParity = 1 and currentParity = 1
         *
         * If targetParity is 1 (odd) so we need to have 
         * 1. prevParity = 0 and currentParity = 1 or
         * 2. prevParity = 1 and currentParity = 0
         *
         * Formulation is (prevParity + currentParity) % 2 = targetParity
         */
        int currentParity = nums[idx] % 2;
        int take = 0;
        int skip = 0;
        if ((prevParity + currentParity) % 2 == targetParity) {
            // we can choose to take or skip
            take = 1 + solveMemoization(idx + 1, currentParity, targetParity, nums, memo);
            skip = solveMemoization(idx + 1, prevParity, targetParity, nums, memo);
        } else {
            // we cannot take it
            skip = solveMemoization(idx + 1, prevParity, targetParity, nums, memo);
        }
        return memo[idx][prevParity][targetParity] = Math.max(take, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (822 / 951 testcases passed)
     */
    public int maximumLengthRecursion(int[] nums) {
        int n = nums.length;
        /**
         * To satisfy the condition: 
         * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2,
         * we need to have sub-sequences with 
         * 1. (even + even) + (even + even) .... or,
         * 2. (odd + odd) + (odd + odd) .....    or,
         * 3. (odd + even) + (odd + even) ... (odd <--> even is swapable)
         *
         * so we need to achieve a parity check
         */
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            maxLength = Math.max(maxLength, 1 + solveRecursion(i + 1, nums[i] % 2, 0, nums));
            maxLength = Math.max(maxLength, 1 + solveRecursion(i + 1, nums[i] % 2, 1, nums));
        }
        return maxLength;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int prevParity, int targetParity, int[] nums) {
        // Base Case
        if (idx == nums.length) {
            return 0;
        }
        // Recursion Calls
        /**
         * If targetParity is 0 (even) so we need to have 
         * 1. prevParity = 0 and currentParity = 0 or
         * 2. prevParity = 1 and currentParity = 1
         *
         * If targetParity is 1 (odd) so we need to have 
         * 1. prevParity = 0 and currentParity = 1 or
         * 2. prevParity = 1 and currentParity = 0
         *
         * Formulation is (prevParity + currentParity) % 2 = targetParity
         */
        int currentParity = nums[idx] % 2;
        int take = 0;
        int skip = 0;
        if ((prevParity + currentParity) % 2 == targetParity) {
            // we can choose to take or skip
            take = 1 + solveRecursion(idx + 1, currentParity, targetParity, nums);
            skip = solveRecursion(idx + 1, prevParity, targetParity, nums);
        } else {
            // we cannot take it
            skip = solveRecursion(idx + 1, prevParity, targetParity, nums);
        }
        return Math.max(take, skip);
    }
}
