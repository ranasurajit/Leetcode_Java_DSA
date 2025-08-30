class Solution {
    /**
     * Approach : Using Array Simulation + Hashing Approach
     *
     * TC: O(9 x 9) + O(9 x 9) + O(9 x 9) ~ O(1)
     * SC: O(9) ~ O(1)
     */
    public boolean isValidSudoku(char[][] board) {
        // validating rows
        for (int row = 0; row < 9; row++) { // TC: O(9)
            Set<Character> hs = new HashSet<Character>(); // SC: O(9)
            for (int col = 0; col < 9; col++) { // TC: O(9)
                if (board[row][col] == '.') {
                    continue;
                }
                if (hs.contains(board[row][col])) {
                    return false;
                }
                hs.add(board[row][col]);
            }
        }
        // validating columns
        for (int col = 0; col < 9; col++) { // TC: O(9)
            Set<Character> hs = new HashSet<Character>(); // SC: O(9)
            for (int row = 0; row < 9; row++) { // TC: O(9)
                if (board[row][col] == '.') {
                    continue;
                }
                if (hs.contains(board[row][col])) {
                    return false;
                }
                hs.add(board[row][col]);
            }
        }
        // validating 3 x 3 sub-boxes
        for (int rowoffset = 0; rowoffset < 3; rowoffset++) {
            for (int coloffset = 0; coloffset < 3; coloffset++) {
                int rowStart = rowoffset * 3;
                int colStart = coloffset * 3;
                Set<Character> hs = new HashSet<Character>(); // SC: O(9)
                for (int row = rowStart; row < rowStart + 3; row++) {
                    for (int col = colStart; col < colStart + 3; col++) {
                        if (board[row][col] == '.') {
                            continue;
                        }
                        if (hs.contains(board[row][col])) {
                            return false;
                        }
                        hs.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
