class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(n, edges, time);
        int[] minTime = new int[n + 1];
        int[] min2Time = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        Arrays.fill(min2Time, Integer.MAX_VALUE);
        minTime[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.time - q.time);
        pq.offer(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            if (min2Time[n] != Integer.MAX_VALUE && u == n) {
                // This means nth node is visited twice so it is 2nd minimum value
                return min2Time[n];
            }
            int curTime = current.time;
            int offset = curTime / change;
            // Check if signal is red, if yes add time - offset to current Time
            int timePassed = offset % 2 == 1 ? (offset + 1) * change : curTime;
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                int edgeTime = time;
                if (edgeTime + timePassed < minTime[v]) {
                    min2Time[v] = minTime[v];
                    minTime[v] = edgeTime + timePassed;
                    pq.offer(new Pair(v, edgeTime + timePassed));
                } else if (min2Time[v] > edgeTime + timePassed && minTime[v] != edgeTime + timePassed) {
                    // This step is to ensure that 2nd min value is strictly larger than 1st min value
                    min2Time[v] = edgeTime + timePassed;
                    pq.offer(new Pair(v, edgeTime + timePassed));
                }
            }
        }
        return min2Time[n];
    }

    private HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges, int time) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return adj;
    }

    class Pair {
        int node;
        int time;
        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
