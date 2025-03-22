class Solution {
    /**
     * Approach III : Using DFS Approach (Better Approach)
     *
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                int[] verticesEdges = { 0, 0 }; // SC: O(1)
                dfsGraphAgain(i, adj, visited, verticesEdges); // TC: O(E), SC: O(V)
                // for complete components e = (v * (v - 1)) / 2
                if (verticesEdges[1] / 2 == (verticesEdges[0] * (verticesEdges[0] - 1)) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraphAgain(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] verticesEdges) {
        visited[u] = true;
        verticesEdges[0]++;
        verticesEdges[1] += adj.getOrDefault(u, new ArrayList<Integer>()).size();
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraphAgain(v, adj, visited, verticesEdges);
            }
        }
    }

    /**
     * Approach II : Using DFS Approach
     *
     * TC: O(4 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V) ~ O(V)
     */
    public int countCompleteComponentsApproachII(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                Set<Integer> compSet = new HashSet<Integer>(); // SC: O(V)
                dfsGraphComponent(i, adj, visited, compSet); // TC: O(E), SC: O(V)
                if (isCompleteComponent(compSet, adj)) { // TC: O(V), SC: O(1)
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(V)
     * SC: O(1)
     */
    private boolean isCompleteComponent(Set<Integer> compSet,
        Map<Integer, ArrayList<Integer>> adj) {
        for (Integer node : compSet) {
            if (adj.getOrDefault(node, new ArrayList<Integer>()).size() 
                != compSet.size() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraphComponent(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, Set<Integer> compSet) {
        visited[u] = true;
        compSet.add(u);
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraphComponent(v, adj, visited, compSet);
            }
        }
    }

    /**
     * Approach I : Using Indegrees and DFS Approach
     *
     * TC: O(4 x V + 2 x E) ~ O(V + E)
     * SC: O(5 x V) ~ O(V)
     */
    public int countCompleteComponentsApproachI(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V)
        int[] indegrees = new int[n]; // SC: O(V)
        int[] componentIndices = new int[n]; // SC: O(V)
        for (int[] edge : edges) { // TC: O(V + E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
            indegrees[edge[1]]++;
            indegrees[edge[0]]++;
        }
        boolean[] visited = new boolean[n]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(V + E)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, componentIndices, count);
                count++;
            }
        }
        int incomplete = 0;
        Map<Integer, List<Integer>> compMap = new HashMap<Integer, List<Integer>>(); // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!compMap.containsKey(componentIndices[i])) {
                compMap.put(componentIndices[i], 
                    Arrays.asList(0, Integer.MAX_VALUE));
            }
            compMap.get(componentIndices[i]).
                set(0, compMap.get(componentIndices[i]).get(0) + 1);
            compMap.get(componentIndices[i]).
                set(1, Math.min(compMap.get(componentIndices[i]).get(1), indegrees[i]));
        }
        for (Integer key : compMap.keySet()) { // TC: O(V)
            List<Integer> comp = compMap.get(key);
            // If minimum indegree < number of vertices per component - 1 then it is incomplete
            if (comp.get(1) < comp.get(0) - 1) {
                incomplete++;
            }
        }
        return count - incomplete;
    }

    /**
     * TC: O(E)
     * SC: O(V)
     */
    private void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] componentIndices, int count) {
        visited[u] = true;
        componentIndices[u] = count;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, componentIndices, count);
            }
        }
    }
}
