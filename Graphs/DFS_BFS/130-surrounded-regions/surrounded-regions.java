class Solution {
    private int m;
    private int n;
    private static final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * Approach : Using DFS Approach
     *
     * TC: O(M x N) + O(M x N) ~ O(M x N)
     * SC: O(M x N) + O(M x N) ~ O(M x N)
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] visited = new int[m][n];  // SC: O(M x N)
        for (int i = 0; i < m; i++) {     // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                // checking for boundary zero and start DFS
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O' && visited[i][j] == 0) {
                        /**
                         * above visited check ensures each cell is visited once 
                         * so Time Complexity is ammortized to O(M x N) only
                         */
                        dfsGraph(i, j, visited, board); // TC: O(M x N), SC: O(M x N)
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * TC: O(M x N) as each cell will be visited exactly once
     * SC: O(M x N)
     */
    private void dfsGraph(int row, int col, int[][] visited, char[][] board) {
        // invalid boundary check
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == 'X' ||
            visited[row][col] == 1) {
            return;
        }
        visited[row][col] = 1;
        for (int[] dir : directions) { // TC: O(4)
            int effRow = row + dir[0];
            int effCol = col + dir[1];
            dfsGraph(effRow, effCol, visited, board);
        }
    }
}
