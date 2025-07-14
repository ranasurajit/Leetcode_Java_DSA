class Solution {
    private int m;
    private int n;
    private int originalValue;

    private static final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * Approach : Using BFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        originalValue = image[sr][sc];
        if (originalValue == color) {
            return image;
        }
        Queue<Pair> queue = new LinkedList<Pair>(); // SC: O(M x N)
        queue.offer(new Pair(sr, sc));
        while (!queue.isEmpty()) { // TC: O(M x N)
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            if (image[row][col] == originalValue) {
                image[row][col] = color;
            }
            for (int[] dir : directions) { // TC: O(4)
                int effRow = row + dir[0];
                int effCol = col + dir[1];
                if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n &&
                    image[effRow][effCol] == originalValue) {
                    image[effRow][effCol] = color;
                    queue.offer(new Pair(effRow, effCol));
                }
            }
        }
        return image;
    }

    private static class Pair {
        int row;
        int col;

        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Approach : Using DFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        originalValue = image[sr][sc];
        if (originalValue == color) {
            return image;
        }
        dfsGraph(sr, sc, image, color);
        return image;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    private void dfsGraph(int i, int j, int[][] image, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != originalValue) {
            return;
        }
        image[i][j] = color;
        dfsGraph(i - 1, j, image, color); // move up
        dfsGraph(i + 1, j, image, color); // move down
        dfsGraph(i, j - 1, image, color); // move left
        dfsGraph(i, j + 1, image, color); // move right
    }
}
