class Solution {
    /**
     * Using Dijkstra's Algorithm
     *
     * TC: O((M x N) x log(M x N))
     * SC: O(M x N)
     */
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            // no paths to move
            return -1;
        }
        boolean[][] visited = new boolean[m][n];         // SC: O(M x N)
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // SC: O(4 x 2)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] p, int[] q) -> p[0] - q[0]);
        pq.offer(new int[] { grid[0][0], 0, 0 }); // store data as { grid value at row i and col j, i, j }
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int row = current[1];
            int col = current[2];
            if (row == m - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            for (int i = 0; i < directions.length; i++) { // TC: O(4)
                int delRow = row + directions[i][0];
                int delCol = col + directions[i][1];
                if (delRow < 0 || delRow >= m || delCol < 0 || delCol >= n || visited[delRow][delCol]) {
                    continue;
                }
                if (grid[delRow][delCol] <= time + 1) {
                    pq.offer(new int[] { time + 1, delRow, delCol });
                } else if ((grid[delRow][delCol] - time) % 2 == 0) {
                    pq.offer(new int[] { grid[delRow][delCol] + 1, delRow, delCol });
                } else {
                    pq.offer(new int[] { grid[delRow][delCol], delRow, delCol });
                }
            }
        }
        return -1;
    }
}
