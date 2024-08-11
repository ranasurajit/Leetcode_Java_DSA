class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = numIslands(grid, rows, cols);
        int days = 0;
        // if the matrix is already disconnected
        if (islands == 0 || islands > 1) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    islands = numIslands(grid, rows, cols);
                    if (islands == 1) {
                        // backtrack to try other possibilities
                        grid[i][j] = 1;
                    } else {
                        return 1;
                    }
                }
            }
        }
        // at most 2 days are required to make any pattern of matrix to make it disconnected
        return 2;
    }

    /**
     * Returns number of islands
     */
    private int numIslands(int[][] grid, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    dfsGraph(grid, visited, i , j, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    /**
     * DFS on graph matrix to move in 4 directions - up, down, left and right
     */
    private void dfsGraph(int[][] grid, int[][] visited, int i , int j, int rows, int cols) {
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || visited[i][j] == 1 || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = 1;
        dfsGraph(grid, visited, i - 1 , j, rows, cols); // up
        dfsGraph(grid, visited, i + 1 , j, rows, cols); // down
        dfsGraph(grid, visited, i , j - 1, rows, cols); // left
        dfsGraph(grid, visited, i , j + 1, rows, cols); // right
    }
}
