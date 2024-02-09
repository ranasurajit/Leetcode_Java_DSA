class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; // rows
        int n = mat[0].length; // cols
        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];

        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            int directions = 4;
            distance[current.row][current.col] = current.dist;

            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];

                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    visited[effRow][effCol] == 0) {
                    visited[effRow][effCol] = 1;
                    queue.offer(new Pair(effRow, effCol, current.dist + 1));
                }
            }
        }
        return distance;
    }

    class Pair {
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}