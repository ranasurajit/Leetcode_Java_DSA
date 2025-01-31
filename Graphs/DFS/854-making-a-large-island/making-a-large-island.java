class Solution {

    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int m;
    private int n;

    /**
     * Using Hashing and DFS Approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        HashMap<Integer, Integer> islandMap =
            new HashMap<Integer, Integer>(); // SC: O(M x N)
        int islandId = 2; // as the matrix is binary so start Ids from 2
        // pre-computing the maximum area any cell covers to form an island
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (grid[i][j] == 1) {
                    int size = dfsGraph(i, j, grid, islandId); // TC: O(M x N)
                    islandMap.put(islandId, size);
                    maxArea = Math.max(maxArea, size);
                    islandId++;
                }
            }
        }
        /**
         * now we will be setting grid cell of value 0 as 1 
         * and check 1 by 1 with its neighbours
         */
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (grid[i][j] == 0) {
                    HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(4)
                    for (int[] direction : directions) { // TC: O(4)
                        int effRow = i + direction[0];
                        int effCol = j + direction[1];
                        if (effRow >= 0 && effRow < m && effCol >= 0 && effCol < n &&
                            grid[effRow][effCol] != 0) {
                            hs.add(grid[effRow][effCol]);
                        }
                    }
                    int sum = 1;
                    for (Integer key : hs) { // TC: O(4)
                        sum += islandMap.get(key);
                    }
                    maxArea = Math.max(maxArea, sum);
                }
            }
        }
        return maxArea;
    }

    /**
     * TC: O(M x N)
     * SC: O(M x N)
     */
    private int dfsGraph(int i, int j, int[][] grid, int islandId) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int count = 1;
        for (int[] direction : directions) {
            int effRow = i + direction[0];
            int effCol = j + direction[1];
            count += dfsGraph(effRow, effCol, grid, islandId);
        }
        return count;
    }
}
