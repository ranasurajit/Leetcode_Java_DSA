class Solution {
    /**
     * TC: O(M x N x log(M x N))
     * SC: O(M x N)
     */
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int trapped = 0;
        /**
         * we would be storing bounday heights and coordinates
         * in the min-heap so that we can poll it in the order of 
         * least height and start comparing with its non-boundary neighbors
         * as how much water it can trap
         * 
         * SC: O(M x N)
         */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]);
        boolean[][] visited = new boolean[m][n];                // SC: O(M x N)
        for (int i = 0; i < m; i++) {                           // TC: O(M)
            for (int j = 0; j < n; j++) {                       // TC: O(N)
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] { heightMap[i][j], i, j });
                    visited[i][j] = true;
;               }
            }
        }
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // RLBT
        while (!pq.isEmpty()) {                                 // TC: O(M x N)
            int[] current = pq.poll();                          // TC: O(log(M x N))
            int currentHeight = current[0];
            int row = current[1];
            int col = current[2];
            // exploring the neighbours as per directions
            for (int idx = 0; idx < directions.length; idx++) { // TC: O(4)
                int effRow = row + directions[idx][0];
                int effCol = col + directions[idx][1];
                if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n &&
                    !visited[effRow][effCol]) {
                    visited[effRow][effCol] = true;
                    trapped += Math.max(currentHeight - heightMap[effRow][effCol], 0);
                    pq.offer(new int[] { 
                        Math.max(currentHeight, heightMap[effRow][effCol]),
                        effRow,
                        effCol
                    });                                        // TC: O(log(M x N))
                }
            }
        }
        return trapped;
    }
}
