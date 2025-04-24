class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N x N)
     *
     * Time Limit Exceeded (42 / 45 testcases passed)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n + 1][n + 1]; // SC: O(N x N)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        // since we have mutiple paths at the last index so we start recursion from index (0, 0)
        return solveMemoization(0, 0, n, triangle, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     */
    private int solveMemoization(int i, int j, int n, List<List<Integer>> triangle,
        int[][] memo) {
        // Base Case
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        // Memoization Check
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        /**
         * as per moves to next subsequent indices i.e. (i)(j) to (i + 1)(j) and (i + 1)(j + 1)
         * it can never go out of bounds
         */
        // Recursive Calls
        int downMove = solveMemoization(i + 1, j, n, triangle, memo);
        int diagonalMove = solveMemoization(i + 1, j + 1, n, triangle, memo);
        return memo[i][j] = triangle.get(i).get(j) + Math.min(downMove, diagonalMove);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ (N x (N + 1)) / 2)
     * SC: O(N)
     *
     * Time Limit Exceeded (42 / 45 testcases passed)
     */
    public int minimumTotalRecursion(List<List<Integer>> triangle) {
        int n = triangle.size();
        // since we have mutiple paths at the last index so we start recursion from index (0, 0)
        return solveRecursion(0, 0, n, triangle);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ (N x (N + 1)) / 2)
     * SC: O(N)
     */
    private int solveRecursion(int i, int j, int n, List<List<Integer>> triangle) {
        // Base Case
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        /**
         * as per moves to next subsequent indices i.e. (i)(j) to (i + 1)(j) and (i + 1)(j + 1)
         * it can never go out of bounds
         */
        // Recursive Calls
        int downMove = triangle.get(i).get(j) + solveRecursion(i + 1, j, n, triangle);
        int diagonalMove = triangle.get(i).get(j) + solveRecursion(i + 1, j + 1, n, triangle);
        return Math.min(downMove, diagonalMove);
    }
}
