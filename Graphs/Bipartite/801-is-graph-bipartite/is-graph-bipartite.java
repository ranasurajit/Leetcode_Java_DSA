class Solution {
    /**
     * Using BFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     * 
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v]; // SC: O(V) this will act as visited array
        Arrays.fill(colors, -1);
        // visiting all nodes having color as -1
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (colors[i] == -1 && !isBFSBipartiteGraph(i, graph, colors, 1)) {
                return false; // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return true;
    }

    /**
     * TC: O(V + 2 x E)
     * SC: O(V)
     * 
     * @param src
     * @param adj
     * @param colors
     * @param currentColor
     * @return
     */
    private boolean isBFSBipartiteGraph(int src, int[][] adj,
            int[] colors, int currentColor) {
        colors[src] = currentColor;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = (int) queue.poll();
            for (int v : adj[u]) {
                if (colors[v] == colors[u]) {
                    return false;
                }
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    queue.offer(v);
                }
            }
        }
        return true;
    }

    /**
     * Using DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     * 
     * @param graph
     * @return
     */
    public boolean isBipartiteDFS(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v]; // SC: O(V) this will act as visited array
        Arrays.fill(colors, -1);

        // visiting all nodes having color as -1
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (colors[i] == -1 && !isDFSBipartiteGraph(i, graph, colors, 1)) {
                return false; // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return true;
    }

    /**
     * TC: O(V + 2 x E)
     * SC: O(V)
     * 
     * @param u
     * @param adj
     * @param colors
     * @param currentColor
     * @return
     */
    private boolean isDFSBipartiteGraph(int u, int[][] adj,
            int[] colors, int currentColor) {
        colors[u] = currentColor;
        for (int v : adj[u]) {
            if (colors[v] == colors[u]) {
                return false;
            }
            int alternateColor = 1 - currentColor;
            if (colors[v] == -1 && 
                !isDFSBipartiteGraph(v, adj, colors, alternateColor)) {
                return false;
            }
        }
        return true;
    }
}
