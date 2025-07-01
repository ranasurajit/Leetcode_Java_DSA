class Solution {
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (1010 / 1111 testcases passed)
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
