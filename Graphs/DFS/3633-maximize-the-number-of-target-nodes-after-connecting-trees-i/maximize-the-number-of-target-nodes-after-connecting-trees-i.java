class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(M ^ 2 + N ^ 2 + M) ~ O(M ^ 2 + N ^ 2)
     * SC: O(M + N)
     */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, ArrayList<Integer>> adj1 = createGraph(edges1); // SC: O(M)
        Map<Integer, ArrayList<Integer>> adj2 = createGraph(edges2); // SC: O(N)
        int m = edges1.length;
        int n = edges2.length;
        int[] result = new int[m + 1];
        for (int i = 0; i < m + 1; i++) { // TC: O(M)
            result[i] = dfsGraph(i, -1, adj1, k); // TC: O(M)
        }
        int maxEdgeContributed = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) { // TC: O(N)
            maxEdgeContributed = Math.max(maxEdgeContributed, dfsGraph(i, -1, adj2, k - 1)); // TC: O(N)
        }
        for (int i = 0; i < m + 1; i++) { // TC: O(M)
            result[i] += maxEdgeContributed;
        }
        return result;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(M + (M + 1)) ~ O(M)
     * SC: O(M)
     */
    private int dfsGraph(int u, int parent, Map<Integer, ArrayList<Integer>> adj, int k) {
        // Base Case
        if (k < 0) {
            return 0;
        }
        int count = 1; // self count of node
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (v != parent) {
                count += dfsGraph(v, u, adj, k - 1);
            }
        }
        return count;
    }

    /**
     * Using Hasing Approach
     *
     * TC: O(M + (M + 1)) ~ O(M)
     * SC: O(M)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(M)
        for (int[] edge : edges) { // TC: O(M)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return adj;
    }
}
