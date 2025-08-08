class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) + Probability Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2) + O(N)
     *
     * - O(N x N) - memoization memory run for N times
     * - O(N) - recursion stack (reused)
     *
     * Accepted (43 / 43 testcases passed)
     */
    public double soupServings(int n) {
        if (n >= 5000) {
            // for larger values of N
            return 1.0;
        }
        int[][] servings = { { 100, 0 }, { 75, 25 }, { 50, 50 }, { 25, 75 } };
        double[][] memo = new double[n + 1][n + 1]; // SC: O(N x N)
        for (double[] mem : memo) {
            Arrays.fill(mem, -1.0);
        }
        return solveMemoizationProbability(n, n, servings, memo); // TC: O(N x N), SC: O(N / 25)
    }

    /**
     * Using Memoization + Probability Approach
     *
     * TC: O(N x N)
     * SC: O(N / 25)
     */
    private double solveMemoizationProbability(int a, int b, int[][] servings, double[][] memo) {
        // Base Case
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            // as we do not expect B soup to be empty
            return 0.0;
        }
        if (memo[a][b] != -1.0) {
            return memo[a][b];
        }
        double probability = 0.0;
        for (int[] serve : servings) {
            int aserve = serve[0];
            int bserve = serve[1];
            probability += solveMemoizationProbability(a - aserve, b - bserve, servings, memo);
        }
        /**
         * we need to multiply 0.25 as per given in question:
         * "On every turn, one of the following four serving operations 
         * is chosen at random, each with probability 0.25 independent 
         * of all previous turns"
         */
        return memo[a][b] = 0.25 * probability;
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2) + O(N)
     *
     * - O(N x N) - memoization memory run for N times
     * - O(N) - recursion stack (reused)
     *
     * Memory Limit Exceeded (20 / 43 testcases passed)
     */
    public double soupServingsMemoization(int n) {
        int[][] servings = { { 100, 0 }, { 75, 25 }, { 50, 50 }, { 25, 75 } };
        double[][] memo = new double[n + 1][n + 1]; // SC: O(N x N)
        for (double[] mem : memo) {
            Arrays.fill(mem, -1.0);
        }
        return solveMemoization(n, n, servings, memo); // TC: O(N x N), SC: O(N / 25)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N / 25)
     */
    private double solveMemoization(int a, int b, int[][] servings, double[][] memo) {
        // Base Case
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            // as we do not expect B soup to be empty
            return 0.0;
        }
        if (memo[a][b] != -1.0) {
            return memo[a][b];
        }
        double probability = 0.0;
        for (int[] serve : servings) {
            int aserve = serve[0];
            int bserve = serve[1];
            probability += solveMemoization(a - aserve, b - bserve, servings, memo);
        }
        /**
         * we need to multiply 0.25 as per given in question:
         * "On every turn, one of the following four serving operations 
         * is chosen at random, each with probability 0.25 independent 
         * of all previous turns"
         */
        return memo[a][b] = 0.25 * probability;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(4 ^ (N / 25))
     * SC: O(N / 25)
     *
     * Time Limit Exceeded (14 / 43 testcases passed)
     */
    public double soupServingsRecursion(int n) {
        int[][] servings = { { 100, 0 }, { 75, 25 }, { 50, 50 }, { 25, 75 } };
        return solveRecursion(n, n, servings); // TC: O(4 ^ (N / 25)), SC: O(N / 25)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(4 ^ (N / 25))
     * SC: O(N / 25)
     */
    private double solveRecursion(int a, int b, int[][] servings) {
        // Base Case
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            // as we do not expect B soup to be empty
            return 0.0;
        }
        double probability = 0.0;
        for (int[] serve : servings) {
            int aserve = serve[0];
            int bserve = serve[1];
            probability += solveRecursion(a - aserve, b - bserve, servings);
        }
        /**
         * we need to multiply 0.25 as per given in question:
         * "On every turn, one of the following four serving operations 
         * is chosen at random, each with probability 0.25 independent 
         * of all previous turns"
         */
        return 0.25 * probability;
    }
}
