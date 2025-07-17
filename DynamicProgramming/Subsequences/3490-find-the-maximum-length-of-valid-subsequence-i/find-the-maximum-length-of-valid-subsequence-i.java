class Solution {
    /**
     * Approach IV : Using Parity Comparison Approach
     *
     * TC: O(N) + O(N)
     * SC: O(1)
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
        int countEvens = 0;
        int countOdds = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if ((nums[i] & 1) == 0) {
                // even
                countEvens++;
            } else {
                countOdds++;
            }
        }
        // also we need to calculate alternating parities
        int prevParity = (nums[0] & 1);
        int countAlternatives = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if ((nums[i] & 1) == 1 - prevParity) {
                countAlternatives++;
                prevParity = (nums[i] & 1);
            }
        }
        return Math.max(countAlternatives, Math.max(countEvens, countOdds));
    }

    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     *
     * TC: O(N) + O(N)
     * SC: O(N)
     *
     * Accepted (951 / 951 testcases passed)
     */
    public int maximumLengthTabulation(int[] nums) {
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
        int[][][] dp = new int[n + 1][2][2]; // SC: O(N x 2 x 2) ~ O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            for (int prevParity = 0; prevParity < 2; prevParity++) {  // TC: O(2)
                for (int targetParity = 0; targetParity < 2; targetParity++) {  // TC: O(2)
                    int currentParity = nums[i] % 2;
                    int take = 0;
                    int skip = 0;
                    if ((prevParity + currentParity) % 2 == targetParity) {
                        // we can choose to take or skip
                        take = 1 + dp[i + 1][currentParity][targetParity];
                        skip = dp[i + 1][prevParity][targetParity];
                    } else {
                        // we cannot take it
                        skip = dp[i + 1][prevParity][targetParity];
                    }
                    dp[i][prevParity][targetParity] = Math.max(take, skip);
                }
            }
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            maxLength = Math.max(maxLength, 1 + dp[i + 1][nums[i] % 2][0]);
            maxLength = Math.max(maxLength, 1 + dp[i + 1][nums[i] % 2][1]);
        }
        return maxLength;
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     *
     * Accepted (951 / 951 testcases passed)
     */
    public int maximumLengthMemoization(int[] nums) {
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
