class Solution {
    private static final int LARGE_VAL = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        HashMap<Integer, ArrayList<long[]>> adj = createGraph(n, edges);
        long minDist = dijkstra(adj, n, source, destination);
        if (minDist < target) {
            return new int[][]{ };
        }
        boolean isTargetEqual = minDist == target;
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = isTargetEqual ? LARGE_VAL : 1;
                if (!isTargetEqual) {
                    adj.get(edge[0]).add(new long[] { edge[1], edge[2] });
                    adj.get(edge[1]).add(new long[] { edge[0], edge[2] });
                    long minCalc = dijkstra(adj, n, source, destination);
                    if (minCalc <= target) {
                        isTargetEqual = true;
                        edge[2] += target - minCalc;
                    }
                }
            }
        }
        return isTargetEqual ? edges : new int[][]{};
    }

    private long dijkstra(HashMap<Integer, ArrayList<long[]>> adj, int n, int src, int dest) {
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>(Comparator.comparingLong(a -> a[1]));
        long[] minDist = new long[n];
        Arrays.fill(minDist, Long.MAX_VALUE);
        pq.offer(new long[]{ src, 0 });
        minDist[src] = 0L;
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int u = (int) current[0];
            long weight = current[1];
            for (long[] pair : adj.get(u)) {
                int v = (int) pair[0];
                long edgeWeight = pair[1];
                if (weight + edgeWeight < minDist[v]) {
                    minDist[v] = weight + edgeWeight;
                    pq.offer(new long[] { v, weight + edgeWeight });
                }
            }
        }
        return minDist[dest];
    }

    private HashMap<Integer, ArrayList<long[]>> createGraph(int n, int[][] edges) {
        HashMap<Integer, ArrayList<long[]>> adj = new HashMap<Integer, ArrayList<long[]>>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<long[]>());
        }
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                adj.get(edge[0]).add(new long[] { edge[1], edge[2] });
                adj.get(edge[1]).add(new long[] { edge[0], edge[2] });
            }
        }
        return adj;
    }
}
