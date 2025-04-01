class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N)
     *
     * Accepted (54 / 54 testcases passed) 
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] memo = new long[n + 1]; // SC: O(N)
        Arrays.fill(memo, -1L);
        return solveMemoization(0, n, questions, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private long solveMemoization(int idx, int n, int[][] questions, long[] memo) {
        // Base Case
        if (idx >= n) {
            return 0L;
        }
        // Memoization Check
        if (memo[idx] != -1L) {
            return memo[idx];
        }
        // Recursion Calls
        // we have option to take or not take
        long nottake = solveMemoization(idx + 1, n, questions, memo);
        int points = questions[idx][0];
        int brainpower = questions[idx][1];
        /**
         * if question at index idx is solved, then next question 
         * that can be solved is at (idx + brainpower + 1)th index
         */
        long take = questions[idx][0] + 
            solveMemoization(idx + brainpower + 1, n, questions, memo);
        return memo[idx] = Math.max(take, nottake);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (32 / 54 testcases passed)
     */
    public long mostPointsRecursion(int[][] questions) {
        int n = questions.length;
        return solveRecursion(0, n, questions);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private long solveRecursion(int idx, int n, int[][] questions) {
        // Base Case
        if (idx >= n) {
            return 0L;
        }
        // Recursion Calls
        // we have option to take or not take
        long nottake = solveRecursion(idx + 1, n, questions);
        int points = questions[idx][0];
        int brainpower = questions[idx][1];
        /**
         * if question at index idx is solved, then next question 
         * that can be solved is at (idx + brainpower + 1)th index
         */
        long take = questions[idx][0] + solveRecursion(idx + brainpower + 1, n, questions);
        return Math.max(take, nottake);
    }
}
