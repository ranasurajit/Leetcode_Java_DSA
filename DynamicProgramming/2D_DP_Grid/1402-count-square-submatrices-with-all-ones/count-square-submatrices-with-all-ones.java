class Solution {
    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(M x N)
     * SC: O(M x N)
     * 
     * - O(M x N) - dp array memory
     *
     * Accepted (32 / 32 testcases passed)
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[][] dp = new int[m][n]; // SC: O(M x N)
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(M x N) x O(M x N)
     * SC: O(M x N) + O(Min(M, N))
     *
     * - O(M x N) - memo array memory
     * - O(Min(M, N)) - recursion stack
     *
     * Accepted (32 / 32 testcases passed)
     */
    public int countSquaresMemoization(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[][] memo = new int[m][n];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (matrix[i][j] == 1) {
                    count += solveMemoization(i, j, m, n, matrix, memo); // TC: O(M x N), SC: O(Min(M, N))
                }
            }
        }
        return count;
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(M x N)
     * SC: O(Min(M, N))
     */
    private int solveMemoization(int row, int col, int m, int n, int[][] matrix, int[][] memo) {
        // Base Case
        if (row >= m || col >= n || matrix[row][col] == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        // Recursion Calls
        int countBottom = solveMemoization(row + 1, col, m, n, matrix, memo);
        int countRight = solveMemoization(row, col + 1, m, n, matrix, memo);
        int countDiagonal = solveMemoization(row + 1, col + 1, m, n, matrix, memo);
        return memo[row][col] = 1 + Math.min(countBottom, Math.min(countRight, countDiagonal));
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(M x N x 3 ^ Min(M, N))
     * SC: O(Min(M, N))
     *
     * Time Limit Exceeded (22 / 32 testcases passed)
     */
    public int countSquaresRecursion(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (matrix[i][j] == 1) {
                    count += solveRecursion(i, j, m, n, matrix); // TC: O(3 ^ Min(M, N)), SC: O(Min(M, N))
                }
            }
        }
        return count;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(3 ^ Min(M, N))
     * SC: O(Min(M, N))
     */
    private int solveRecursion(int row, int col, int m, int n, int[][] matrix) {
        // Base Case
        if (row >= m || col >= n || matrix[row][col] == 0) {
            return 0;
        }
        // Recursion Calls
        int countBottom = solveRecursion(row + 1, col, m, n, matrix);
        int countRight = solveRecursion(row, col + 1, m, n, matrix);
        int countDiagonal = solveRecursion(row + 1, col + 1, m, n, matrix);
        return 1 + Math.min(countBottom, Math.min(countRight, countDiagonal));
    }
}
