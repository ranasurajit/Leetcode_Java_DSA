class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
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
            int directions = 4;
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            distance[current.row][current.col] = current.distance;
            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];
                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    visited[effRow][effCol] == 0) {
                    visited[effRow][effCol] = 1;
                    queue.offer(new Pair(effRow, effCol, current.distance + 1));
                }
            }
        }
        return distance;
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
