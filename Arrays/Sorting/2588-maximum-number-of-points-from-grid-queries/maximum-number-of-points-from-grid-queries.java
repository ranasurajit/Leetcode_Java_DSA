class Solution {
    private final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1} };
    private int m;
    private int n;

    /**
     * Approach III : Using Min-Heap and Sorting Approach
     *
     * TC: O(Q + Q x log(Q) + (M x N) x log(M x N)) ~ O(Q x log(Q) + (M x N) x log(M x N))
     * SC: O(2 x M x N) ~ O(M x N)
     *
     * Accepted (21 / 21 testcases passed)
     */
    public int[] maxPoints(int[][] grid, int[] queries) {
        m = grid.length;
        n = grid[0].length;
        int q = queries.length;
        int[] result = new int[q];
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; 
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]); // TC: O(Q x log(Q))
        boolean[][] visited = new boolean[m][n]; // SC: O(M x N)
        // Use a Min-Heap to store { grid[i][j], i, j } the minimum value of grid at the peek
        PriorityQueue<int[]> pq = 
            new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); // SC: O(M x N)
        pq.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;
        int points = 0;
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int query = sortedQueries[i][0];
            int index = sortedQueries[i][1];
            while (!pq.isEmpty() && pq.peek()[0] < query) { // TC: O(M x N)
                int[] current = pq.poll();
                points++;
                for (int[] direction : directions) {
                    int effRow = current[1] + direction[0];
                    int effCol = current[2] + direction[1];
                    if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n &&
                        !visited[effRow][effCol]) {
                        pq.offer(new int[] { 
                            grid[effRow][effCol],
                            effRow,
                            effCol
                        }); // TC: O(log(M x N))
                        visited[effRow][effCol] = true;
                    }
                }
            }
            result[index] = points;
        }
        return result;
    }

    /**
     * Approach II : Using DFS Approach on each Query
     *
     * TC: O(Q x M x N)
     * SC: O(Q x M x N)
     *
     * Time Limit Exceeded (17 / 21 testcases passed)
     */
    public int[] maxPointsDFS(int[][] grid, int[] queries) {
        m = grid.length;
        n = grid[0].length;
        int q = queries.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) { // TC: O(Q)
            boolean[][] visited = new boolean[m][n]; // SC: O(M x N)
            int points = 0;
            if (grid[0][0] < queries[i]) {
                points = dfsGraph(0, 0, queries[i], visited, grid); // TC: O(M x N)
            }
            result[i] = points;
        }
        return result;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    private int dfsGraph(int row, int col, int query, boolean[][] visited, int[][] grid) {
        if (row < 0 || row >= m || col < 0 || col >= n || 
            visited[row][col] || query <= grid[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int points = 1;
        for (int[] direction : directions) {
            int effRow = row + direction[0];
            int effCol = col + direction[1];
            points += dfsGraph(effRow, effCol, query, visited, grid);
        }
        return points;
    }

    /**
     * Approach I : Using BFS Approach on each Query
     *
     * TC: O(Q x M x N)
     * SC: O(Q x M x N)
     *
     * Time Limit Exceeded (17 / 21 testcases passed)
     */
    public int[] maxPointsBFS(int[][] grid, int[] queries) {
        m = grid.length;
        n = grid[0].length;
        int q = queries.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) { // TC: O(Q)
            boolean[][] visited = new boolean[m][n]; // SC: O(M x N)
            int points = 0;
            if (grid[0][0] < queries[i]) {
                points = bfsGraph(new int[] { 0, 0 }, queries[i], visited, grid); // TC: O(M x N)
            }
            result[i] = points;
        }
        return result;
    }

    /**
     * Using BFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    private int bfsGraph(int[] src, int query, boolean[][] visited, int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(src);
        visited[src[0]][src[1]] = true;
        int points = 1;
        while (!queue.isEmpty()) { // TC: O(Q)
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int effRow = current[0] + direction[0];
                int effCol = current[1] + direction[1];
                if (effRow >= 0 && effRow < m &&
                    effCol >= 0 && effCol < n &&
                    !visited[effRow][effCol] && grid[effRow][effCol] < query) {
                    points += 1;
                    visited[effRow][effCol] = true;
                    queue.offer(new int[] { effRow, effCol });
                }
            }
        }
        return points;
    }
}
