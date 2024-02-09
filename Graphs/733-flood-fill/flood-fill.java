class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int targetValue = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        Pair source = new Pair(sr, sc);

        bfsGraph(image, visited, source, color, targetValue, m, n);
        return image;
    }

    private void bfsGraph(int[][] image, boolean[][] visited, Pair source, 
        int color, int targetValue, int m, int n) {
        image[source.row][source.col] = color;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            visited[source.row][source.col] = true;
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            int directions = 4;

            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];

                if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n && 
                    !visited[effRow][effCol] && image[effRow][effCol] == targetValue) {
                    visited[effRow][effCol] = true;
                    image[effRow][effCol] = color;
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