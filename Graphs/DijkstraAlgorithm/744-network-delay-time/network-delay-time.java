class Solution {
    /**
     * Using Dijkstra's Algorithm
     *
     * TC: O((V + E) x log(V))
     * SC: O(V + E)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // creating the Adjacency List
        Map<Integer, ArrayList<int[]>> adj =
            new HashMap<Integer, ArrayList<int[]>>();           // SC: O(V + E)
        for (int[] edge : times) {                              // TC: O(E)
            adj.computeIfAbsent(edge[0], 
                p -> new ArrayList<int[]>()).add(new int[] { edge[1], edge[2] });
        }
        // creating min-heap to store (weight, node) -          // SC: O(V)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]);
        int[] minDist = new int[n + 1];                         // SC: O(V)
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[k] = 0;
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {                                 // TC: O(V)
            int[] current = pq.poll();                          // TC: O(log(V))
            int time = current[0];
            int u = current[1];
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) {
                int v = ngbr[0];
                int edgeTime = ngbr[1];
                if (time + edgeTime < minDist[v]) {
                    minDist[v] = time + edgeTime;
                    pq.offer(new int[] { time + edgeTime, v }); // TC: O(log(E))
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {                         // TC: O(V)
            maxTime = Math.max(maxTime, minDist[i]);
        }
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
