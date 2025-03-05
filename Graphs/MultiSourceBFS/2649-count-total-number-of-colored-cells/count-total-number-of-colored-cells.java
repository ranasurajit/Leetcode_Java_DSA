class Solution {
    /**
     * Approach II : Using Math
     *
     * TC: O(K x K) where K = (2 x N - 1)
     * SC: O(K x K) 
     *
     * maximum visits possible is all cells of size (2 x N - 1)
     */
    public long coloredCells(int n) {
        /**
         * For each incremental n to n + 1, each cell will 
         * contribute 4 times of its neighboring cells (n)
         */
        long coloredCells = 1;
        int count = 1;
        while (count < n) {
            coloredCells += 4 * count;
            count++;
        }
        return coloredCells;
    }

    /**
     * Approach I : Using Graphs - MultiSource BFS Approach
     *
     * TC: O(K x K) where K = (2 x N - 1)
     * SC: O(K x K) 
     *
     * maximum visits possible is all cells of size (2 x N - 1)
     */
    public long coloredCellsApproachI(int n) {
        if (n == 1) {
            return 1L;
        }
        int dim = 2 * n - 1;
        int rows = dim;
        int cols = dim;
        boolean[][] visited = new boolean[rows][cols]; // SC: O(K x K)
        return bfsGraphMultiSource(dim / 2, dim / 2, visited, rows, cols, n);
    }

    /**
     * TC: O(K x K) where K = (2 x N - 1)
     * SC: O(K x K) 
     *
     * maximum visits possible is all cells of size (2 x N - 1)
     */
    private long bfsGraphMultiSource(int i, int j, boolean[][] visited,
        int rows, int cols, int n) {
        Queue<int[]> queue = new LinkedList<int[]>();
        // adding (n - 1) to the queue to represent minutes left
        queue.offer(new int[] { i, j, n - 1 });
        visited[i][j] = true;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        long count = 1L;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int p = 0; p < directions.length; p++) {
                int effRow = current[0] + directions[p][0];
                int effCol = current[1] + directions[p][1];
                // validate rows and columns
                if (effRow >= 0 && effRow < rows && effCol >= 0 && effCol < cols
                   && !visited[effRow][effCol] && current[2] > 0) {
                    visited[effRow][effCol] = true;
                    queue.offer(new int[] { effRow, effCol, current[2] - 1 });
                    count++;
                }
            }
        }
        return count;
    }
}
