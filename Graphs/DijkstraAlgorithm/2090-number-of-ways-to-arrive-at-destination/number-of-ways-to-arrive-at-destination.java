class Solution {
    /**
     * Using Dijkstra's Algorithm Approach
     *
     * TC: O((V + E) x (1 + log(V))) ~ O((V + E) x log(V))
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public int countPaths(int n, int[][] roads) {
        Map<Integer, ArrayList<int[]>> adj = 
            new HashMap<Integer, ArrayList<int[]>>(); // TC: O(V + E), SC: O(V + E)
        for (int[] edge : roads) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<int[]>())
                .add(new int[] { edge[1], edge[2] });
            adj.computeIfAbsent(edge[1], k -> new ArrayList<int[]>())
                .add(new int[] { edge[0], edge[2] });
        }

        int mod = (int) 1e9 + 7;

        long[] minDist = new long[n]; // SC: O(V)
        Arrays.fill(minDist, Long.MAX_VALUE / 2);
        minDist[0] = 0;

        PriorityQueue<long[]> pq = 
            new PriorityQueue<long[]>(Comparator.comparingLong(a -> a[1])); // SC: O(V)
        pq.offer(new long[] { 0, 0 });
        int[] countMinPaths = new int[n]; // SC: O(V)
        countMinPaths[0] = 1;

        while (!pq.isEmpty()) { // TC: O((V + E) x log(V))
            long[] current = pq.poll();
            int u = (int) current[0];
            long w = current[1];
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) {
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if (edgeWeight + w < minDist[v]) {
                    minDist[v] = edgeWeight + w;
                    pq.offer(new long[] { v, edgeWeight + w });
                    countMinPaths[v] = countMinPaths[u];
                } else if (edgeWeight + w == minDist[v]) {
                    countMinPaths[v] = (countMinPaths[v] + countMinPaths[u]) % mod;
                }
            }
        }
        return countMinPaths[n - 1];
    }
}
