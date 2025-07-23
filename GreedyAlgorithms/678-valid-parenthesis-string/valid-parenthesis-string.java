class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N) + O(N x N) ~ O(N x N)
     * SC: O(N x N) + O(N)
     * 
     * - O(N x N) - memoization memory
     * - O(N) - recursion stack
     *
     * Accepted (83 / 83 testcases passed)
     */
    public boolean checkValidString(String s) {
        int n = s.length();
        int[] count = { 0 };
        // index and count are the states that we need to memoize
        int[][] memo = new int[n][n]; // SC: O(N x N)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(N)
        }
        return solveMemoization(0, n, count, s, memo); // TC: O(N x N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     */
    private boolean solveMemoization(int idx, int n, int[] count, String s, int[][] memo) {
        // Base Case
        if (count[0] < 0) {
            return false;
        }
        if (idx == n) {
            return count[0] == 0;
        }
        // Memoization Check
        if (memo[idx][count[0]] != -1) {
            return memo[idx][count[0]] == 1;
        }
        // Recursion Calls
        boolean result = false;
        if (s.charAt(idx) == '(') {
            result = solveMemoization(idx + 1, n, new int[] { count[0] + 1 }, s, memo);
        } else if (s.charAt(idx) == ')') {
            result = solveMemoization(idx + 1, n, new int[] { count[0] - 1 }, s, memo);
        } else {
            // we can replace '*' with '('
            boolean replaceWithOpen = solveMemoization(idx + 1, n, new int[] { count[0] + 1 }, s, memo);
            // we can replace '*' with ')'
            boolean replaceWithClose = solveMemoization(idx + 1, n, new int[] { count[0] - 1 }, s, memo);
            // we can replace '*' with ''
            boolean replaceWithEmptyString = solveMemoization(idx + 1, n, count, s, memo);
            result = replaceWithOpen || replaceWithClose || replaceWithEmptyString;
        }
        memo[idx][count[0]] = result ? 1 : 0;
        return result;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(3 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (79 / 83 testcases passed)
     */
    public boolean checkValidStringRecursion(String s) {
        int n = s.length();
        int[] count = { 0 };
        return solveRecursion(0, n, count, s); // TC: O(3 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(3 ^ N)
     * SC: O(N)
     */
    private boolean solveRecursion(int idx, int n, int[] count, String s) {
        // Base Case
        if (count[0] < 0) {
            return false;
        }
        if (idx == n) {
            return count[0] == 0;
        }
        // Recursion Calls
        if (s.charAt(idx) == '(') {
            return solveRecursion(idx + 1, n, new int[] { count[0] + 1 }, s);
        } else if (s.charAt(idx) == ')') {
            return solveRecursion(idx + 1, n, new int[] { count[0] - 1 }, s);
        } else {
            // we can replace '*' with '('
            boolean replaceWithOpen = solveRecursion(idx + 1, n, new int[] { count[0] + 1 }, s);
            // we can replace '*' with ')'
            boolean replaceWithClose = solveRecursion(idx + 1, n, new int[] { count[0] - 1 }, s);
            // we can replace '*' with ''
            boolean replaceWithEmptyString = solveRecursion(idx + 1, n, count, s);
            return replaceWithOpen || replaceWithClose || replaceWithEmptyString;
        }
    }
}
