class Solution {
    /**
     * Using Tabulation
     *
     * TC: O(N)
     * TC: O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        for (int i = 2; i < n; i++) { // TC: O(N)
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

    /**
     * Using Memoization
     *
     * TC: O(N)
     * TC: O(2 x N)
     */
    public int minCostClimbingStairsMemoization(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min(solveMemoization(0, cost, n, memo),
            solveMemoization(1, cost, n, memo));
    }

    /**
     * Using Memoization
     *
     * TC: O(N)
     * TC: O(N)
     */
    private int solveMemoization(int index, int[] cost, int n, int[] memo) {
        // Base Case
        if (index >= n) {
            return 0;
        }
        // Memoization Check
        if (memo[index] != -1) {
            return memo[index];
        }
        // Recursion Calls
        int oneStepCost = cost[index] + solveMemoization(index + 1, cost, n, memo);
        int twoStepCost = cost[index] + solveMemoization(index + 2, cost, n, memo);
        return memo[index] = Math.min(oneStepCost, twoStepCost);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 x 2 ^ N) ~ O(2 ^ (N + 1))
     * TC: O(2 x N) ~ O(N)
     */
    public int minCostClimbingStairsRecursion(int[] cost) {
        int n = cost.length;
        return Math.min(solveRecursion(0, cost, n), solveRecursion(1, cost, n));
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ N)
     * TC: O(N)
     */
    private int solveRecursion(int index, int[] cost, int n) {
        // Base Case
        if (index >= n) {
            return 0;
        }
        // Recursion Calls
        int oneStepCost = cost[index] + solveRecursion(index + 1, cost, n);
        int twoStepCost = cost[index] + solveRecursion(index + 2, cost, n);
        return Math.min(oneStepCost, twoStepCost);
    }
}
