class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(2 x V + E) ~ O(V + E)
     * SC: O(V) + O(V)
     */
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v]; // SC: O(V)
        Arrays.fill(colors, -1); // initially no color is assigned
        for (int i = 0; i < v; i++) { // TC: O(V)
            // say we have two colors 0 and 1 and we start with 0
            if (colors[i] == -1 && !dfsGraph(i, graph, colors, 0)) { // TC: O(V + E), SC: O(V)
                return false;
            }
        }
        return true;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraph(int u, int[][] graph, int[] colors, int currentColor) {
        colors[u] = currentColor;
        for (int v : graph[u]) {
            if (colors[v] == colors[u]) {
                // cannot have same color in neighbours
                return false;
            }
            if (colors[v] == -1 && !dfsGraph(v, graph, colors, 1 - currentColor)) {
                return false;
            }
        }
        return true;
    }
}
