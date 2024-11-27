class Solution {
    /**
     * Using Dijkstra Algorithm Aproach
     * 
     * TC: O(Q x E x log(V))
     * SC: O(3V) ~ O(V)
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] shortestDist = new int[q]; // SC: O(Q)
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(n); // SC: O(V)
        for (int i = 0; i < q; i++) {           // TC: O(Q)
            adj.get(queries[i][0]).add(queries[i][1]);
            shortestDist[i] = dijkstraPath(adj, n, 0); // TC: O(E x log(V)), SC: O(2V)
        }
        return shortestDist;
    }

    /**
     * Using Dijkstra Algorithm
     * 
     * TC: O(E x log(V))
     * SC: O(2V)
     */
    private int dijkstraPath(HashMap<Integer, ArrayList<Integer>> adj, 
        int n, int src) {
        // Min-heap created - SC: O(V)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] p, int[] q) -> {
            return p[1] - q[1];
        }); // TC: O(V x log(V))
        int[] minPath = new int[n]; // SC: O(V)
        Arrays.fill(minPath, Integer.MAX_VALUE);
        minPath[src] = 0;
        pq.offer(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int weight = current[1];
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                int edgeWeight = 1;
                if (edgeWeight + weight < minPath[v]) {
                    minPath[v] = edgeWeight + weight;
                    pq.offer(new int[] { v, edgeWeight + weight });
                }
            }
        }
        return minPath[n - 1];
    }

    /**
     * Using Graph BFS Aproach
     * 
     * TC: O(Q x (V + E))
     * SC: O(3V) ~ O(V)
     */
    public int[] shortestDistanceAfterQueriesUsingBFS(int n, int[][] queries) {
        int q = queries.length;
        int[] shortestDist = new int[q]; // SC: O(Q)
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(n); // SC: O(V)
        for (int i = 0; i < q; i++) {           // TC: O(Q)
            adj.get(queries[i][0]).add(queries[i][1]);
            shortestDist[i] = bfsGraph(adj, n); // TC: O(V + E), SC: O(2V)
        }
        return shortestDist;
    }

    /**
     * Graph BFS Algorithm
     * 
     * TC: O(V + 2E) ~ O(V + E)
     * SC: O(2V)
     */
    private int bfsGraph(HashMap<Integer, ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visited[0] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer u = queue.poll();
                if (u == n - 1) {
                    return level;
                }
                for (Integer v : adj.get(u)) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
            level++;
        }
        return level;
    }

    private HashMap<Integer, ArrayList<Integer>> createGraph(int n) {
        HashMap<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n - 1; i++) {
            // there is a unidirectional road from city i to city i + 1
            adj.put(i, new ArrayList<Integer>());
            adj.get(i).add(i + 1);
        }
        return adj;
    }
}
