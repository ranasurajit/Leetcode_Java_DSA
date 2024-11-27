class Solution {
    /**
     * Using BFS Approach
     *
     * TC: O(Q x E x log(V))
     * SC: O(V + E)
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] distances = new int[q];
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(n); // TC: O(V), SC: O(V)
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int[] query = queries[i];
            int u = query[0];
            int v = query[1];
            adj.get(u).add(v);
            distances[i] = bfsGraph(adj, n); // TC: O(E x log(V))
        }
        return distances;
    }

    /**
     * Using BFS Approach
     *
     * TC: O(E x log(V))
     * SC: O(V + E)
     */
    private int bfsGraph(HashMap<Integer, ArrayList<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
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

    /**
     * Using BFS Approach
     *
     * TC: O(V)
     * SC: O(V)
     */
    private HashMap<Integer, ArrayList<Integer>> createGraph(int n) {
        HashMap<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>();
        // as it is mentioned that edges are unidirectional from city i to (i + 1)
        for (int i = 0; i < n - 1; i++) {
            adj.put(i, new ArrayList<Integer>());
            adj.get(i).add(i + 1);
        }
        return adj;
    }
}
