class Solution {
    private static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * Approach : Using Dijkstra's Algorithm Approach
     * 
     * TC: O(M x N) + O(4 x M x N x log(M x N)) ~ O(M x N x log(M x N))
     * SC: O(M x N) + O(M x N) ~ O(M x N)
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minEffort = new int[m][n]; // SC: O(M x N)
        for (int[] row : minEffort) {      // TC: O(M)
            Arrays.fill(row, (int) 1e8);   // TC: O(N)
        }
        minEffort[0][0] = 0; // effort from source to source = 0
        // we will be using a Min-Heap to store { effort, row, col } in-order of effort
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(M x N)
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) { // TC: O(M x N)
            int[] current = pq.poll();
            int effort = current[0];
            int row = current[1];
            int col = current[2];
            for (int[] dir : directions) { // TC: O(4)
                int effRow = row + dir[0];
                int effCol = col + dir[1];
                if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n) {
                    int edgeEffort = Math.abs(heights[effRow][effCol] - heights[row][col]);
                    int maxEdgeEffort = Math.max(effort, edgeEffort);
                    if (minEffort[effRow][effCol] > maxEdgeEffort) {
                        minEffort[effRow][effCol] = maxEdgeEffort;
                        pq.offer(new int[] { maxEdgeEffort, effRow, effCol }); // TC: O(log(M x N))
                    }
                }
            }
        }
        return minEffort[m - 1][n - 1];
    }
}
