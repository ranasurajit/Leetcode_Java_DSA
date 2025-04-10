class Solution {
    /**
     * Using Prim's Algorithm Approach
     *
     * TC: O(V ^ 2 x log(V))
     * SC: O(V ^ 2 + V)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, ArrayList<int[]>> adj = 
            createGraph(n, points); // TC: O(V ^ 2), SC: TC: O(V ^ 2)
        // Min-Heap to store edges based on weights - int[] { weight, node }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(V ^ 2)
        pq.offer(new int[] { 0, 0 });
        boolean[] visited = new boolean[n]; // SC: O(V)
        int minCost = 0;
        while (!pq.isEmpty()) { // TC: O(V ^ 2)
            int[] current = pq.poll(); // TC: O(log(V))
            int w = current[0];
            int u = current[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            minCost += w;
            for (int[] ngbr : adj.get(u)) {
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if (!visited[v]) {
                    pq.offer(new int[] { edgeWeight, v }); // TC: O(log(V))
                }
            }
        }
        return minCost;
    }
    
    /**
     * Creating Adjacency List
     *
     * TC: O(V ^ 2 + V) ~ O(V ^ 2)
     * SC: O(V ^ 2)
     */
    private Map<Integer, ArrayList<int[]>> createGraph(int v, int[][] points) {
        Map<Integer, ArrayList<int[]>> adj =
            new HashMap<Integer, ArrayList<int[]>>(); // SC: O(V x V)
        for (int i = 0; i < v; i++) { // TC: O(V)
            adj.put(i, new ArrayList<int[]>());
        }
        for (int i = 0; i < v; i++) { // TC: O(V)
            for (int j = i + 1; j < v; j++) { // TC: O(V)
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] { j, weight });
                adj.get(j).add(new int[] { i, weight });
            }
        }
        return adj;
    }
}
