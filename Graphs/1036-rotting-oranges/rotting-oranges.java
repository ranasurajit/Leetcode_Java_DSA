class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int freshOranges = 0;
        int convertedOranges = 0;
        int minTime = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    queue.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int row = currentPair.row;
            int col = currentPair.col;
            int time = currentPair.time;
            if (time > minTime) {
                minTime = time;
            }
            int[] deltaRow = { -1, 0, 1, 0 };
            int[] deltaCol = { 0, 1, 0, -1 };
            int directions = 4;

            for (int k = 0; k < directions; k++) {
                int effRow = row + deltaRow[k];
                int effCol = col + deltaCol[k];
                if (effRow >= 0 && effRow < m && 
                    effCol >= 0 && effCol < n && 
                    visited[effRow][effCol] == 0 && grid[effRow][effCol] == 1) {
                    visited[effRow][effCol] = 1;
                    grid[effRow][effCol] = 2;
                    queue.offer(new Pair(effRow, effCol, time + 1));
                    convertedOranges++;
                }
            }
        }
        return convertedOranges == freshOranges ? minTime : -1;
    }

    class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
