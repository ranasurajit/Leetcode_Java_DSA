class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; // rows
        int n = grid[0].length; // cols
        int[][] visited = new int[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    bfsGraph(grid, visited, i, j, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfsGraph(char[][] grid, int[][] visited, int row, int col, int m, int n) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(row, col));
        visited[row][col] = 1;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int directions = 4;
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };

            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];

                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    grid[effRow][effCol] == '1' && visited[effRow][effCol] == 0) {
                    visited[effRow][effCol] = 1;
                    queue.offer(new Pair(effRow, effCol));
                }
            }
        }
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}