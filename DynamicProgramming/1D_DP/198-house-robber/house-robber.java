class Solution {
    /**
     * Approach II: Using Memoization (Top-Down DP)
     *
     * TC: O(N) - Each subproblem (index) is solved once
     *
     * SC: O(N + N)
     *   - O(N) for memo array
     *   - O(N) recursion stack depth in worst case
     *
     * Accepted (70 / 70 testcases passed)
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solveMemoization(n - 1, nums, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] nums, int[] memo) {
        // Base Case
        if (n == 0) {
            return nums[0];
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        // rob nth house and then try with (n - 2)th house
        int option1 = nums[n];
        if (n > 1) {
            option1 += solveMemoization(n - 2, nums, memo);
        }
        // do not rob nth house so try with (n - 1)th house
        int option2 = solveMemoization(n - 1, nums, memo);
        return memo[n] = Math.max(option1, option2);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N) - At each index, you decide to rob or skip → exponential branching
     * SC: O(N) - Due to recursion stack depth
     *
     * Time Limit Exceeded (55 / 70 testcases passed)
     */
    public int robRecursion(int[] nums) {
        int n = nums.length;
        return solveRecursion(n - 1, nums);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N) - At each index, you decide to rob or skip → exponential branching
     * SC: O(N) - Due to recursion stack depth
     */
    private int solveRecursion(int n, int[] nums) {
        // Base Case
        if (n == 0) {
            return nums[0];
        }
        // Recursion Calls
        // rob nth house and then try with (n - 2)th house
        int option1 = nums[n];
        if (n > 1) {
            option1 += solveRecursion(n - 2, nums);
        }
        // do not rob nth house so try with (n - 1)th house
        int option2 = solveRecursion(n - 1, nums);
        return Math.max(option1, option2);
    }
}
