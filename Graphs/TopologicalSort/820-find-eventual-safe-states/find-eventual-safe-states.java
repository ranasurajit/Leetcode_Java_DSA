class Solution {
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(2 x V + E) + O(V) ~ O(V + E)
     * SC: O(V) + O(V) ~ O(V)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        /**
         * A node which is a part of any cycle cannot only end up in a terminal node
         * so, Safe nodes will be the one which are not a part of any cycle
         * DFS Approach : we need to exclude those nodes where inRecursion is false
         */
        boolean[] visited = new boolean[n];     // SC: O(V)
        boolean[] inRecursion = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, visited, inRecursion, graph); // TC: O(V + E), SC: O(V)
            }
        }
        // store all safe nodes where inRecursion[i] = false
        List<Integer> safeNodes = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!inRecursion[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraph(int u, boolean[] visited, boolean[] inRecursion, int[][] graph) {
        visited[u] = true;
        inRecursion[u] = true;
        for (int v : graph[u]) {
            if (!visited[v] && dfsGraph(v, visited, inRecursion, graph)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}
