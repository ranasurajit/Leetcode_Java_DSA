class Solution {
    /**
     * Using Dijkstra's Algorithm
     * TC: O((M x N) + (M x N) log (M x N))
     * SC: O(M x N)
     */
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Min-heap to store [a, b, c] where (a, b) are cells and c is weight 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] p, int[] q) -> {
            return p[2] - q[2];
        });
        int[][] minDist = new int[m][n]; // SC: O(M x N)
        for (int[] minDist1D : minDist) { // TC: O(M x N)
            Arrays.fill(minDist1D, Integer.MAX_VALUE);
        }
        minDist[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cellX = current[0];
            int cellY = current[1];
            int weight = current[2];
            for (int i = 0; i < directions.length; i++) {
                int delX = cellX + directions[i][0];
                int delY = cellY + directions[i][1];
                if (delX >= 0 && delX < m && delY >= 0 && delY < n) {
                    int edgeWeight = grid[delX][delY] == 1 ? 1 : 0;
                    if (weight + edgeWeight < minDist[delX][delY]) {
                        minDist[delX][delY] = weight + edgeWeight;
                        pq.offer(new int[] { delX, delY, weight + edgeWeight });
                    }
                }
            }
        }
        return minDist[m - 1][n - 1];
    }
}
