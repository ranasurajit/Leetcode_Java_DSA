class Solution {
    private static int MOD = (int) 1e9 + 7;
    /**
     * Approach : Using Dijkstra's Algorithm Approach
     *
     * TC: O(2 x E) + O(4 x E x log(E)) ~ O(E x log(V))
     * SC: O(V + E) + O(2 x E) + O(V) ~ O(V + E)
     */
    public int countPaths(int n, int[][] roads) {
        Map<Integer, ArrayList<int[]>> adj = createGraph(roads); // TC: O(2 x E), SC: O(V + E)
        int src = 0;
        int dest = n - 1;
        long[] minDuration = new long[n]; // SC: O(V)
        Arrays.fill(minDuration, Long.MAX_VALUE);
        minDuration[src] = 0;
        // we will be storing { duration, node } in the Min-Heap
        PriorityQueue<long[]> pq = 
            new PriorityQueue<long[]>((p, q) -> Long.compare(p[0], q[0])); // SC: O(2 x E)
        pq.offer(new long[] { 0, src });
        int[] countMinPaths = new int[n]; // SC: O(V)
        countMinPaths[0] = 1;
        while (!pq.isEmpty()) { // TC: O(2 x E)
            long[] current = pq.poll();
            long duration = current[0];
            int u = (int) current[1];
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) { // TC: O(2 x E)
                int v = ngbr[0];
                long edgeDuration = ngbr[1];
                if (duration + edgeDuration < minDuration[v]) {
                    minDuration[v] = duration + edgeDuration;
                    pq.offer(new long[] { duration + edgeDuration, v }); // TC: O(log(V))
                    countMinPaths[v] = countMinPaths[u] % MOD;
                } else if (duration + edgeDuration == minDuration[v]) {
                    countMinPaths[v] = (countMinPaths[v] + countMinPaths[u] % MOD) % MOD;
                }
            }
        }
        return countMinPaths[dest] % MOD;
    }

    /**
     * Using Hashing Approach
     *
     * TC: O(2 x E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<int[]>> createGraph(int[][] roads) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<Integer, ArrayList<int[]>>();
        for (int[] edge : roads) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<int[]>())
                    .add(new int[] { edge[1], edge[2] });
            adj.computeIfAbsent(edge[1], k -> new ArrayList<int[]>())
                    .add(new int[] { edge[0], edge[2] });
        }
        return adj;
    } 
}
