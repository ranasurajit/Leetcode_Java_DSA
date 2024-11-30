class Solution {
    /**
     * TC: O(V + E)
     * SC: O(V + E)
     */
    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        HashMap<Integer, Integer> indegrees =
            new HashMap<Integer, Integer>();                      // SC: O(V)
        HashMap<Integer, Integer> outdegrees =
            new HashMap<Integer, Integer>();                      // SC: O(V)
        HashMap<Integer, List<Integer>> adj = 
            createGraph(pairs, indegrees, outdegrees);            // SC: O(V)
        int startNode = pairs[0][0];
        for (Integer node : adj.keySet()) {                       // TC: O(V)
            if (outdegrees.getOrDefault(node, 0) - 
                indegrees.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }
        ArrayList<Integer> eulersPath = new ArrayList<Integer>(); // SC: O(V)
        dfsGraph(adj, startNode, eulersPath);                 // TC: O(V + E), SC: O(V)
        int[][] arranged = new int[n][2];                         // SC: O(E x 2)
        for (int i = 1; i < eulersPath.size(); i++) {             // TC: O(V)
            arranged[i - 1] = new int[] { eulersPath.get(i - 1), eulersPath.get(i) };
        }
        return arranged;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(HashMap<Integer, List<Integer>> adj, 
        int node, ArrayList<Integer> eulersPath) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove(adj.get(node).size() - 1);
            dfsGraph(adj, nextNode, eulersPath);
        }
        eulersPath.add(0, node);
    }

    /**
     * TC: O(E)
     * SC: O(E)
     */
    private HashMap<Integer, List<Integer>> createGraph(int[][] pairs,         
        HashMap<Integer, Integer> indegrees, HashMap<Integer, Integer> outdegrees) {
        HashMap<Integer, List<Integer>> adj =
            new HashMap<Integer, List<Integer>>();
        for (int[] pair : pairs) { // TC: O(E)
            int u = pair[0];
            int v = pair[1];
            adj.computeIfAbsent(u, k -> new ArrayList<Integer>()).add(v);
            outdegrees.put(u, outdegrees.getOrDefault(u, 0) + 1);
            indegrees.put(v, indegrees.getOrDefault(v, 0) + 1);
        }
        return adj;
    }
}
