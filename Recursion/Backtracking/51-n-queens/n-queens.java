class Solution {
    /**
     * Approach I : Using Recursion + Backtracking Approach
     *
     * TC: O(N ^ 3 x N! + N ^ 2) ~ O(N ^ 3 x N!)
     * SC: O(N ^ 2 + N) ~ O(N ^ 2)
     */
    public List<List<String>> solveNQueens(int n) {
        // preparing the board
        List<String> board = new ArrayList<String>(); // SC: O(N x N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            StringBuilder sb = new StringBuilder(); // SC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                sb.append(".");
            }
            board.add(sb.toString());
        }
        List<List<String>> result = new ArrayList<List<String>>();
        // calling recursion function
        solveBacktrack(0, n, board, result); // TC: O(N ^ 3 x N!), SC: O(N)
        return result;
    }

    /**
     * Using Recursion + Backtracking Approach
     *
     * TC: O(N ^ 3 x N!)
     * SC: O(N)
     */
    private void solveBacktrack(int col, int n, List<String> board, List<List<String>> result) {
        // Base Case
        if (col == n) {
            result.add(new ArrayList<String>(board));
            return;
        }
        // Recursion Calls
        for (int row = 0; row < n; row++) { // TC: O(N)
            if (col == 0 || isQueenSafe(row, col, n, board)) { // TC: O(N ^ 2)
                // modify
                StringBuilder s = new StringBuilder(board.get(row));
                s.setCharAt(col, 'Q');
                board.set(row, s.toString());
                // explore - we need to place next queen in next column
                solveBacktrack(col + 1, n, board, result);
                // backtrack
                s.setCharAt(col, '.');
                board.set(row, s.toString());
            }
        }
    }

    /**
     * Simple Simulation and Matrix Validation Approach
     *
     * TC: O(2 x N ^ 2 + 2 x N) ~ O(N ^ 2)
     * SC: O(1)
     */
    private boolean isQueenSafe(int row, int col, int n, List<String> board) {
        // check in same row
        for (int j = 0; j < n; j++) { // TC: O(N)
            if (j == col) {
                continue;
            }
            if (board.get(row).charAt(j) == 'Q') {
                return false;
            }
        }
        // check in same column
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i == row) {
                continue;
            }
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // check in right diagonal
        int sumCellIndex = row + col;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i == row) {
                continue;
            }
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (j == col) {
                    continue;
                }
                if (i + j == sumCellIndex && board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
        }
        // check in left diagonal
        int diffCellIndex = row - col;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i == row) {
                continue;
            }
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (j == col) {
                    continue;
                }
                if (i - j == diffCellIndex && board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
        }
        // by this point Queen position at (row, col) is safe
        return true;
    }
}
