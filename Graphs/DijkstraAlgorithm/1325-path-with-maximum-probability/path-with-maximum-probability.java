class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, ArrayList<Pair>> adj = createGraph(n, edges, succProb);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p, q) -> -Double.compare(p.weight, q.weight));
        double[] maxDist = new double[n];
        Arrays.fill(maxDist, Double.MIN_VALUE);
        maxDist[start_node] = 1.0;
        pq.offer(new Pair(start_node, 1.0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            double dist = current.weight;
            for (Pair p : adj.getOrDefault(u, new ArrayList<Pair>())) {
                int v = p.node;
                double edgeWeight = p.weight;
                if (dist * edgeWeight > maxDist[v]) {
                    maxDist[v] = dist * edgeWeight;
                    pq.offer(new Pair(v, dist * edgeWeight));
                }
            }
        }
        return maxDist[end_node];
    }

    private HashMap<Integer, ArrayList<Pair>> createGraph(int n, int[][] edges, double[] succProb) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        return adj;
    }

    class Pair {
        int node;
        double weight;

        public Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
