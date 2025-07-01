class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x S) + O(N)
     * SC: O(N x S) + O(N)
     *
     * Accepted (141 / 141 testcases passed)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        /**
		 * we have to find two partitions such that: partition 1 has all 
         * +ve symbol elements and partition 2 has all -ve symbol elements
		 * |s1 - s2| = target
		 *  s1 + s2 = total
		 * so s1 = (d + total) / 2, so the problem or s2 = (total - d) / 2
		 * reduces to find the count of subsets with target = s2 = (total - d) / 2
		 */
        // Checking for edge cases - not possible to get such partition
        if (total - target < 0) {
            return 0;
        }
        if ((total - target) % 2 == 1) {
            return 0;
        }
        // so now target becomes = calculation / 2
        target = (total - target) / 2;
        int[][] memo = new int[n + 1][target + 1]; // SC: O(N x S)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(n - 1, nums, target, memo);
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x S)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int[] nums, int target, int[][] memo) {
        // Base Case
        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][target] != -1) {
            return memo[idx][target];
        }
        // Recursion Calls
        int pick = 0;
        int skip = 0;
        if (nums[idx] <= target) {
            // we can pick or skip
            pick = solveMemoization(idx - 1, nums, target - nums[idx], memo);
            skip = solveMemoization(idx - 1, nums, target, memo);
        } else {
            // we cannot pick at all
            skip = solveMemoization(idx - 1, nums, target, memo);
        }
        return memo[idx][target] = pick + skip;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Accepted (141 / 141 testcases passed)
     */
    public int findTargetSumWaysRecursion(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        /**
		 * we have to find two partitions such that: partition 1 has all 
         * +ve symbol elements and partition 2 has all -ve symbol elements
		 * |s1 - s2| = target
		 *  s1 + s2 = total
		 * so s1 = (d + total) / 2, so the problem 
		 * reduces to find the count of subsets with target = s1 = (d + total) / 2
		 */
        int calculation = target + total;
        if ((calculation & 1) != 0) {
            // not possible to get such partition
            return 0;
        }
        // so now target becomes = calculation / 2
        target = calculation / 2;
        return solveRecursion(n - 1, nums, target);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int[] nums, int target) {
        // Base Case
        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }
        // Recursion Calls
        int pick = 0;
        int skip = 0;
        if (nums[idx] <= target) {
            // we can pick or skip
            pick = solveRecursion(idx - 1, nums, target - nums[idx]);
            skip = solveRecursion(idx - 1, nums, target);
        } else {
            // we cannot pick at all
            skip = solveRecursion(idx - 1, nums, target);
        }
        return pick + skip;
    }
}
