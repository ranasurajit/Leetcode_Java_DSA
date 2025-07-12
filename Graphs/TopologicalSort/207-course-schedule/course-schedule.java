class Solution {
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(E) + O(2 x V + E) ~ O(V + E)
     * SC: O(V + E) + O(V) + O(V) + O(V) ~ O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // creating Adjacency List
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : prerequisites) { // TC: O(E)
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        /**
         * we can finish all courses if and only if there's no cyclic dependency, 
         * so we need to check, if this Directed Graph is cyclic in nature
         */
        // using DFS Approach
        boolean[] visited = new boolean[numCourses]; // SC: O(V)
        boolean[] inRecursion = new boolean[numCourses]; // SC: O(V)
        for (int i = 0; i < numCourses; i++) { // TC: O(V)
            if (!visited[i] && dfsGraph(i, visited, inRecursion, adj)) { // TC: O(V + E), SC: O(V)
                // this indicates that there is a cycle in graph
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
    private boolean dfsGraph(int u, boolean[] visited, boolean[] inRecursion,
        Map<Integer, ArrayList<Integer>> adj) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v] && dfsGraph(v, visited, inRecursion, adj)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}
