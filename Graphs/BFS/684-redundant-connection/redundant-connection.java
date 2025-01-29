class Solution {
    /**
     * Using BFS Approach
     * 
     * TC: O(E ^ 2)
     * SC: O(2 x E) ~ O(E)
     * 
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();

        for (int[] edge : edges) { // TC: O(E)
            if (adj.containsKey(edge[0]) && adj.containsKey(edge[1]) &&
                    bfsIfPathPresent(edge[0], edge[1], adj, n)) {
                return edge;
            }
            /**
             * edge[0] or edge[1] is not present so
             * add it in adjacency list - TC: O(2 x E)
             */
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return new int[] {};
    }

    /**
     * TC: O(E)
     * SC: O(E)
     * 
     * @param src
     * @param des
     * @param adj
     * @param visited
     * @return
     */
    private boolean bfsIfPathPresent(int src, int des,
            Map<Integer, ArrayList<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(src);
        visited[0] = true;
        visited[src] = true;

        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            if (u == des) {
                return true;
            }
            for (Integer v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return false;
    }

    /**
     * Using DFS Approach
     * 
     * TC: O(E ^ 2)
     * SC: O(2 x E) ~ O(E)
     * 
     * @param edges
     * @return
     */
    public int[] findRedundantConnectionDFS(int[][] edges) {
        int n = edges.length;
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) { // TC: O(E)
            /**
             * check if edges exist in graph and if we can reach
             * from edge[0] to edge[1] then edge will be redundant
             */
            boolean[] visited = new boolean[n + 1]; // SC: O(E)
            visited[0] = true; // as vertices are from 1 to n
            if (adj.containsKey(edge[0]) && adj.containsKey(edge[1]) &&
                    dfsIfPathPresent(edge[0], edge[1], adj, visited)) {
                return edge; // TC: O(E), SC: O(E)
            }
            /**
             * edge[0] or edge[1] is not present so
             * add it in adjacency list - TC: O(2 x E)
             */
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return new int[] {};
    }

    /**
     * TC: O(E)
     * SC: O(E)
     * 
     * @param src
     * @param des
     * @param adj
     * @param visited
     * @return
     */
    private boolean dfsIfPathPresent(int src, int des,
            Map<Integer, ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        if (src == des) {
            return true;
        }
        for (Integer v : adj.get(src)) {
            if (!visited[v] && dfsIfPathPresent(v, des, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
