class Solution {
    /**
     * Approach V : Using Better Approach
     *
     * TC: O(L)
     * SC: O(1)
     *
     * Accepted (958 / 958 testcases passed)
     */
    public long distributeCandies(int n, int limit) {
        long count = 0L;
        for (int i = 0; i <= Math.min(limit, n); i++) { // TC: O(L)
            int s = n - i; // s = j + k
            if (s > 2 * limit) {
                continue;
            }
            int jmax = Math.min(limit, s);
            int jmin = Math.max(0, s - limit);
            count += (jmax - jmin + 1);
        }
        return count;
    }

    /**
     * Approach IV : Using Better Brute-Force Approach
     *
     * TC: O(L ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (515 / 958 testcases passed)
     */
    public long distributeCandiesBetterBruteForce(int n, int limit) {
        long count = 0L;
        for (int i = 0; i <= limit; i++) { // TC: O(L)
            for (int j = 0; j <= limit; j++) { // TC: O(L)
                int k = n - i - j;
                if (k >= 0 && k <= limit) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach III : Using Simulation/Brute-Force Approach
     *
     * TC: O(L ^ 3)
     * SC: O(1)
     *
     * Time Limit Exceeded (500 / 958 testcases passed)
     */
    public long distributeCandiesBruteForce(int n, int limit) {
        long count = 0L;
        for (int i = 0; i <= limit; i++) { // TC: O(L)
            for (int j = 0; j <= limit; j++) { // TC: O(L)
                for (int k = 0; k <= limit; k++) { // TC: O(L)
                    if (i + j + k == n) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(L x N)
     * SC: O(N)
     *
     * Time Limit Exceeded (508 / 958 testcases passed)

     */
    public long distributeCandiesMemoization(int n, int limit) {
        int[] sum = { 0 };
        int[][] memo = new int[4][n + 1]; // SC: O(4 x (N + 1)) ~ O(4 x N) ~ O(N)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(0, 0, 3, n, limit, memo); // TC: O(L x N), SC: O(1)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(4 x L x N) ~ O(L x N)
     * SC: O(3) ~ O(1)
     */
    private int solveMemoization(int index, int currentSum, int children, int n, int limit, int[][] memo) {
        // Base Case
        if (index == children) {
            return currentSum == n ? 1 : 0;
        }
        // Memoization Check
        if (memo[index][currentSum] != -1) {
            return memo[index][currentSum];
        }
        // Recursion Calls
        int totalways = 0;
        for (int i = 0; i <= Math.min(limit, n - currentSum); i++) { // TC: O(L)
            if (currentSum + i <= n) {
                // explore
                totalways += solveMemoization(index + 1, currentSum + i, children, n, limit, memo);
            }
        }
        return memo[index][currentSum] = totalways;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(L ^ 3)
     * SC: O(3) ~ O(1)
     *
     * Time Limit Exceeded (500 / 958 testcases passed)

     */
    public long distributeCandiesRecursion(int n, int limit) {
        int[] sum = { 0 };
        return solveRecursion(0, 3, n, sum, limit);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(L ^ 3)
     * SC: O(3) ~ O(1)
     */
    private int solveRecursion(int index, int children, int n, int[] sum, int limit) {
        // Base Case
        if (index == children) {
            return sum[0] == n ? 1 : 0;
        }
        // Recursion Calls
        int totalways = 0;
        for (int i = 0; i <= limit; i++) { // TC: O(L)
            if (sum[0] <= n) {
                // modify
                sum[0] += i;
                // explore
                totalways += solveRecursion(index + 1, children, n, sum, limit);
                // backtrack
                sum[0] -= i;
            }
        }
        return totalways;
    }
}
