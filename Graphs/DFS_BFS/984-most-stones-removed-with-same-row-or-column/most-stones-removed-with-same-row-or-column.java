class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(N x N) ~ O(N ^ 2)
     * SC: O(N) + O(N) ~ O(N)
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n]; // SC: O(N)
        int components = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (visited[i]) {
                continue;
            }
            dfsGraph(i, n, visited, stones); // TC: O(N), SC: O(N)
            components++;
        }
        return n - components;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsGraph(int index, int n, boolean[] visited, int[][] stones) {
        visited[index] = true;
        int row = stones[index][0];
        int col = stones[index][1];
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!visited[i] && (stones[i][0] == row || stones[i][1] == col)) {
                dfsGraph(i, n, visited, stones);
            }
        }
    }
}
