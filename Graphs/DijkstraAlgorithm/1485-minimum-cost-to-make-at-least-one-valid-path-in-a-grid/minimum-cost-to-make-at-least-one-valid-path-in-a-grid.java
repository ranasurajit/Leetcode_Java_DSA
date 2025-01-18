class Solution {
    private int m;
    private int n;
    // directions - right (0), left (1), down (2), up (3) 
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * Using Dijkstra Algorithm Approach
     *
     * TC: O((M x N) x log(M x N))
     * SC: O(2 x M x N) ~ O(M x N)
     */
    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] result = new int[m][n];  // SC: O(M x N)
        for (int[] item : result) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        // Min-heap to store { cost, row, col } based upon minimum cost
                                         // SC: O(M x N)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]);
        result[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 }); // TC: O(log(1))
        while (!pq.isEmpty()) {          // TC: O(M x N)
            int[] current = pq.poll();   // TC: O(log(M x N))
            int currentCost = current[0];
            int i = current[1];
            int j = current[2];
            for (int idx = 0; idx < directions.length; idx++) {
                int effRow = i + directions[idx][0];
                int effCol = j + directions[idx][1];
                // check if cell (effRow, effCol) is valid for (m x n) grid
                if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n) {
                    int modifyDirCost = grid[i][j] != idx + 1 ? 1 : 0;
                    if (currentCost + modifyDirCost < result[effRow][effCol]) {
                        result[effRow][effCol] = currentCost + modifyDirCost;
                        pq.offer(new int[] { 
                            currentCost + modifyDirCost,
                            effRow,
                            effCol
                        });               // TC: O(log(M x N))
                    }
                }
            }
        }
        return result[m - 1][n - 1];
    }

    /**
     * Brute-Force Approach (Using Recursion and Backtracking)
     *
     * TC: O(4 ^ (M x N))
     * SC: O(2 x M x N) ~ O(M x N)
     */
    public int minCostBruteForce(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; // SC: O(M x N)
        return backtrack(0, 0, grid, visited, 0);
    }

    /**
     * TC: O(4 ^ (M x N))
     * SC: O(M x N)
     */
    private int backtrack(int i, int j, int[][] grid, boolean[][] visited, int cost) {
        // base case
        if (i == m - 1 && j == n - 1) {
            return cost;
        }
        int minCost = Integer.MAX_VALUE;
        // marking cell at (i, j) visited
        visited[i][j] = true;
        for (int idx = 0; idx < directions.length; idx++) {
            int effRow = i + directions[idx][0];
            int effCol = j + directions[idx][1];
            // check if cell (effRow, effCol) is valid for (m x n) grid and unvisited
            if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n &&
                !visited[effRow][effCol]) {
                int modifyDirCost = grid[i][j] != idx + 1 ? 1 : 0;
                minCost = Math.min(
                    minCost,
                    backtrack(effRow, effCol, grid, visited, cost + modifyDirCost)
                );
            }
        }
        // when done backtrack the visited and mark unvisited for further exploration
        visited[i][j] = false;
        return minCost;
    }
}
