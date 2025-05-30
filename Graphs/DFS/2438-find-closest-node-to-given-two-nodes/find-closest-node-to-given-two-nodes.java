class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(4 x N) ~ O(N)
     * SC: O(7 x N) ~ O(N)
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        if (node1 == node2) {
            return node1;
        }
        // Creating adjacency list
        Map<Integer, ArrayList<Integer>> adj = createGraph(edges, n); // TC: O(N), SC: O(N)

        // initializing distance arrays
        int[] dist1 = new int[n]; // SC: O(N)
        int[] dist2 = new int[n]; // SC: O(N)
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        // performing DFS traversal to fill the distances
        boolean[] visited1 = new boolean[n]; // SC: O(N)
        boolean[] visited2 = new boolean[n]; // SC: O(N)
        dfsGraph(node1, visited1, adj, dist1); // TC: O(N), SC: O(N)
        dfsGraph(node2, visited2, adj, dist2); // TC: O(N), SC: O(N)
        
        int minDist = Integer.MAX_VALUE;
        int resultNode = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int currentMax = Math.max(dist1[i], dist2[i]);
            if (minDist > currentMax) {
                minDist = currentMax;
                resultNode = i;
            }
        }
        return resultNode;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsGraph(int u, boolean[] visited, Map<Integer, ArrayList<Integer>> adj, int[] dist) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dist[v] = dist[u] + 1;
                dfsGraph(v, visited, adj, dist);
            }
        }
    }

    /**
     * Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[] edges, int n) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!adj.containsKey(i)) {
                adj.put(i, new ArrayList<Integer>());
            }
            if (edges[i] != -1) {
                adj.get(i).add(edges[i]);
            }
        }
        return adj;
    }
}
