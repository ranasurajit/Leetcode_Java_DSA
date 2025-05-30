class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(6 x N) ~ O(N)
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        if (node1 == node2) {
            return node1;
        }
        // initializing distance arrays
        int[] dist1 = new int[n]; // SC: O(N)
        int[] dist2 = new int[n]; // SC: O(N)
        boolean[] visited1 = new boolean[n]; // SC: O(N)
        boolean[] visited2 = new boolean[n]; // SC: O(N)
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        // performing DFS traversal to fill the distances
        dfsGraph(node1, visited1, edges, dist1); // TC: O(N), SC: O(N)
        dfsGraph(node2, visited2, edges, dist2); // TC: O(N), SC: O(N)
        
        // compare shortest distances
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
    private void dfsGraph(int u, boolean[] visited, int[] edges, int[] dist) {
        visited[u] = true;
        int v = edges[u];
        if (v != -1 && !visited[v]) {
            dist[v] = dist[u] + 1;
            dfsGraph(v, visited, edges, dist);
        }
    }
}
