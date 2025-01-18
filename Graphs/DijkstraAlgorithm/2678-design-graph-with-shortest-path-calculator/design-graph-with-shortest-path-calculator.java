class Graph {
    private Map<Integer, ArrayList<int[]>> adj;
    private int n;

    /**
     * TC: O(V + E)
     * SC: O(V + E)
     * 
     * @param n
     * @param edges
     */
    public Graph(int n, int[][] edges) {
        this.n = n;
        this.adj = new HashMap<Integer, ArrayList<int[]>>();
        for (int i = 0; i < n; i++) { // TC: O(V)
            this.adj.put(i, new ArrayList<int[]>());
        }
        for (int[] edge : edges) { // TC: O(E)
            // as it is a directed weighted graph
            this.adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     * 
     * @param edge
     */
    public void addEdge(int[] edge) {
        this.adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }
    
    /**
     * TC: O((V + E) x log(V))
     * SC: O(2 x V) ~ O(V)
     * 
     * @param node1
     * @param node2
     * @return
     */
    public int shortestPath(int node1, int node2) {
        int[] minDist = new int[n];                             // SC: O(V)
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[node1] = 0; // node1 is the source node
        // min-heap to store { edgeCost, node } in order of edgeCost
                                                                // SC: O(V)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]);
        pq.offer(new int[] { 0, node1 });
        while (!pq.isEmpty()) {                                 // TC: O(V)
            int[] current = pq.poll();                          // TC: O(log(V))
            int cost = current[0];
            int u = current[1];
            for (int[] neighbour : adj.get(u)) {                // TC: O(E)
                int v = neighbour[0];
                int edgeCost = neighbour[1];
                if (cost + edgeCost < minDist[v]) {
                    minDist[v] = cost + edgeCost;
                    pq.offer(new int[] { cost + edgeCost, v }); // TC: O(log(V))
                }
            }
        }
        return minDist[node2] == Integer.MAX_VALUE ? -1 : minDist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
