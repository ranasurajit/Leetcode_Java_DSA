class Solution {
    /**
     * Approach : Using Hashing + Graph Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     *
     * where L = average count of digits in nums i.e. 1 <= L <= 10
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        /**
         * This problem looks like a Graph where adjacentPairs denotes
         * that there is an edge between u --> v
         * so, we need to use HashMap to create the adjacency list 
         */
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int[] edge : adjacentPairs) { // TC: O(N)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        int startNode = -1;
        for (Integer u : adj.keySet()) { // TC: O(N)
            if (adj.get(u).size() == 1) {
                startNode = u;
                break;
            }
        }
        int[] path = new int[adjacentPairs.length + 1];
        dfsGraph(startNode, Integer.MAX_VALUE, adj, 0, path); // TC: O(N), SC: O(N)
        return path;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsGraph(int u, int prev, Map<Integer, ArrayList<Integer>> adj, int index, int[] path) {
        path[index] = u;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (v != prev) {
                dfsGraph(v, u, adj, index + 1, path);
            }
        }
    }
}
