class Solution {
    /**
     * Approach I : Using Prim's Algorithm for Minimum Spanning Tree
     *
     * TC: O(N ^ 2 + N ^ 2 x log(N ^ 2)) ~ O(N ^ 2 x log(N ^ 2))
     * SC: O(3 x N ^ 2 + N) ~ O(N ^ 2)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost = 0;
        Map<Integer, ArrayList<int[]>> adj =
            createAdjacencyList(points, n); // TC: O(E), SC: O(2 x E)
        boolean[] visited = new boolean[n]; // SC: O(N)
        // we would need a PriorityQueue (Min-Heap) to store edges in order of edgeCosts
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(E)
        pq.offer(new int[] { 0, 0 }); // TC: O(log(E))
        while (!pq.isEmpty()) { // TC: O(E)
            int[] current = pq.poll(); // TC: O(log(E))
            int cost = current[0];
            int u = current[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            minCost += cost;
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) { // TC: O(E)
                int v = ngbr[0];
                int edgeCost = ngbr[1];
                if (!visited[v]) {
                    pq.offer(new int[] { edgeCost, v }); // TC: O(log(E))
                }
            }
        }
        return minCost;
    }

    /**
     * Creating AdjacencyList
     *
     * TC: O(N ^ 2)
     * SC: O(2 x N ^ 2)
     */
    private Map<Integer, ArrayList<int[]>> createAdjacencyList(int[][] points, int n) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<Integer, ArrayList<int[]>>();
        for (int i = 0; i < n - 1; i++) {     // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<int[]>()).add(new int[] { j, weight });
                adj.computeIfAbsent(j, k -> new ArrayList<int[]>()).add(new int[] { i, weight });
            }
        }
        return adj;
    }
}
