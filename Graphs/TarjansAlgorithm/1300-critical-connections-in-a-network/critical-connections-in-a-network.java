class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> criticalEdges = new ArrayList<List<Integer>>();
        // Create adjacency list
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N + E)
        for (List<Integer> edge : connections) { // TC: O(E)
            adj.computeIfAbsent(edge.get(0), k -> new ArrayList<Integer>()).add(edge.get(1));
            adj.computeIfAbsent(edge.get(1), k -> new ArrayList<Integer>()).add(edge.get(0));
        }
        boolean[] visited = new boolean[n]; // SC: O(N)
        /**
         * creating two arrays:
         * 1. tin: store time required for first DFS for a node and,
         * 2. low: store lowest time to reach a node from it adjacent nodes other than parent node
         */
        int[] tin = new int[n]; // SC: O(N)
        int[] low = new int[n]; // SC: O(N)
        dfsGraph(0, -1, adj, visited, tin, low, criticalEdges);
        return criticalEdges;
    }

    private void dfsGraph(int u, int parent, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] tin, int[] low, List<List<Integer>> criticalEdges) {
        visited[u] = true;
        tin[u] = low[u] = timer;
        timer++;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (v == parent) {
                continue;
            }
            if (!visited[v]) {
                dfsGraph(v, u, adj, visited, tin, low, criticalEdges);
                low[u] = Math.min(low[u], low[v]);
                // to check if there is a critical edge from u -> v
                if (low[v] > tin[u]) {
                    criticalEdges.add(Arrays.asList(v, u));
                }
            } else {
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }
}
