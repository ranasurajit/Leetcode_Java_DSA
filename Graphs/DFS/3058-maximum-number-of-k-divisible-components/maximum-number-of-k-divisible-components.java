class Solution {
    /**
     * TC: O(2 x (V + E)) ~ O(V + E)
     * SC: O(2 x (V + E)) ~ O(V + E)
     */
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(n, edges);
        int[] count = { 0 }; 
        dfsGraph(adj, values, k, count, 0, -1);
        return count[0];
    }

    /**
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private int dfsGraph(HashMap<Integer, ArrayList<Integer>>adj, int[] values,
        int k, int[] count, int u, int parent) {
        long sum = values[u];
        for (Integer v : adj.get(u)) {
            if (v != parent) {
                sum += dfsGraph(adj, values, k, count, v, u);
            }
        }
        sum = sum % k; 
        // check if sum is divisible by k then increase count if sum % k = 0
        if (sum == 0) {
            count[0]++;
        }
        return (int) sum;
    }

    /**
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) { // TC: O(V)
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {    // TC: O(E)
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}
