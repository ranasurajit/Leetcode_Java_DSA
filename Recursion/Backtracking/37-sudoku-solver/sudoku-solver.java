class Solution {
    /**
     * Approach : Using Recursion + Backtracking Approach
     *
     * TC: O(9 ^ M)
     * SC: O(M)
     *
     * where M = empty cells (.) and each empty cell has 9 possibilities to be filled
     */
    public void solveSudoku(char[][] board) {
        solvedSudokuRecursion(board);
    }

    /**
     * Using Recursion + Backtracking Approach
     *
     * TC: O(9 ^ M)
     * SC: O(M)
     *
     * where M = empty cells (.) and each empty cell has 9 possibilities to be filled
     */
    private boolean solvedSudokuRecursion(char[][] board) {
        for (int i = 0; i < 9; i++) { // TC: O(9)
            for (int j = 0; j < 9; j++) { // TC: O(9)
                if (board[i][j] == '.') {
                    // explore setting characters '1' to '9' in board[i][j]
                    for (char ch = '1'; ch <= '9'; ch++) { // TC: O(9)
                        if (isValidSudoku(board, i, j, ch)) {
                            board[i][j] = ch; // modify
                            if (solvedSudokuRecursion(board)) { // explore
                                return true;
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(3 x 9) ~ O(1)
     * SC: O(1)
     */
    private boolean isValidSudoku(char[][] board, int i, int j, char ch) {
        // validate rows
        for (int row = 0; row < 9; row++) { // TC: O(9)
            if (board[row][j] == ch) {
                return false;
            }
        }
        // validate columns
        for (int col = 0; col < 9; col++) { // TC: O(9)
            if (board[i][col] == ch) {
                return false;
            }
        }
        // validate 3 x 3 sub-boxes
        int rowoffset = i >= 6 ? 6: (i >= 3 ? 3 : 0);
        int coloffset = j >= 6 ? 6: (j >= 3 ? 3 : 0);
        for (int r = rowoffset; r < rowoffset + 3; r++) { // TC: O(3)
            for (int c = coloffset; c < coloffset + 3; c++) { // TC: O(3)
                if (board[r][c] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
