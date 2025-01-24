class Solution {
    /**
     * Using DFS on Directed Graph approach
     *
     * TC: O(2 x V + E) ~ O(V + E)
     * SC: O(V + E)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<Integer> safeNodes = new ArrayList<Integer>();
        boolean[] visited = new boolean[v];
        boolean[] inRecursion = new boolean[v];
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsCycleGraph(i, graph, visited, inRecursion);
            }
        }
        // unsafe nodes will still be having inRecursion value as True as they will be in cycle
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (!inRecursion[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    /**
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private boolean dfsCycleGraph(int u, int[][] graph, boolean[] visited,
        boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (int v : graph[u]) {
            if (!visited[v] && dfsCycleGraph(v, graph, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        // recursion has winded up here so marking inRecursion at vertex u as false;
        inRecursion[u] = false;
        return false;
    }
}
