class Solution {
    private static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * Approach : Using Dijkstra's Algorithm Approach
     *
     * TC: O(2 x N x M x log(N x M)) ~ O(N x M x log(N x M))
     * SC: O(2 x N x M) ~ O(N x M)
     */
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        // capture minimum time as per Dijkstra's Algorithm
        int[][] minTime = new int[n][m]; // SC: O(N x M)
        for (int[] t : minTime) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;
        // Min-Heap to store { time, row, col }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(N x M)
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) { // TC: O(N x M)
            int[] current = pq.poll(); // TC: O(log(N x M))
            int time = current[0];
            int row = current[1];
            int col = current[2];
            if (row == n - 1 && col == m - 1) {
                return minTime[n - 1][m - 1];
            }
            for (int[] dir : directions) {
                int effRow = row + dir[0];
                int effCol = col + dir[1];
                if (effRow >= 0 && effRow < n && effCol >= 0 && effCol < m) {
                    int edgeTime = 1;
                    int waitTime = Math.max(0, moveTime[effRow][effCol] - time);
                    int finalTime = edgeTime + waitTime + time;
                    if (finalTime < minTime[effRow][effCol]) {
                        minTime[effRow][effCol] = finalTime;
                        pq.offer(new int[] { finalTime, effRow, effCol }); // TC: O(log(N x M))
                    }
                }
            }
        }
        return -1;
    }
}
