class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; // rows
        int n = grid[0].length; // cols
        int[][] visited = new int[m][n];
        int freshOranges = 0;

        Queue<Pair> queue = new LinkedList<Pair>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2 && visited[i][j] == 0) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int convertedOranges = 0;
        int time = 0;

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int directions = 4;
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            time = Math.max(time, current.time);

            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];
                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    visited[effRow][effCol] == 0 &&
                    grid[effRow][effCol] == 1) {
                    convertedOranges++;
                    visited[effRow][effCol] = 1;
                    queue.offer(new Pair(effRow, effCol, current.time + 1));
                }
            }
        }
        return (freshOranges == convertedOranges) ? time : -1;
    }

    class Pair {
        int row;
        int col;
        int time;

        public Pair (int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}