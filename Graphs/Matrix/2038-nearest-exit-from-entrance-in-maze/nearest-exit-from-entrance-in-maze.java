class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == '+') {
                    visited[i][j] = 1;
                }
            }
        }
        queue.offer(new Pair(entrance[0], entrance[1], 0));
        visited[entrance[0]][entrance[1]] = 1;
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int row = currentPair.row;
            int col = currentPair.col;
            int distance = currentPair.distance;
            System.out.println("Current: " + distance);
            int directions = 4;
            int[] deltaRow = { -1, 0, 1, 0 };
            int[] deltaCol = { 0, 1, 0, -1 };
            for (int i = 0; i < directions; i++) {
                int effRow = row + deltaRow[i];
                int effCol = col + deltaCol[i];
                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    visited[effRow][effCol] == 0 &&
                    maze[effRow][effCol] == '.') {
                    visited[effRow][effCol] = 1;
                    if (effRow == 0 || effRow == m - 1 || effCol == 0 || effCol == n - 1) {
                        return distance + 1;
                    } else {
                        queue.offer(new Pair(effRow, effCol, distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
