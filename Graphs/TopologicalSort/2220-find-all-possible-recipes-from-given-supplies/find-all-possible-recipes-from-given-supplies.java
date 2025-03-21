class Solution {
    /**
     * Approach: Using Topological Sort Approach
     *
     * TC: O(N x K + S + (S x (S + K)) + N) ~ O(N x K + S x K + S x S)
     * SC: O(N x K + (N + S)) ~ O(N x K)
     */
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
        String[] supplies) {
        int n = recipes.length;
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> adj = new HashMap<String, List<String>>(); // SC: O(N x K)
        Map<String, Integer> indegrees = new HashMap<String, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (String ingred : ingredients.get(i)) { // TC: O(K)
                adj.computeIfAbsent(ingred, k -> new ArrayList<String>()).add(recipes[i]);
                indegrees.put(recipes[i], indegrees.getOrDefault(recipes[i], 0) + 1);
            }
        }
        Queue<String> queue = new LinkedList<String>(); // SC: O(S)
        // supplies items will be having indegree 0 so add them in the queue
        for (String s : supplies) { // TC: O(S)
            queue.offer(s);
        }
        Set<String> canBePrepared = new HashSet<String>();
        while (!queue.isEmpty()) { // TC: O(S)
            String u = queue.poll();
            for (String v : adj.getOrDefault(u, new ArrayList<String>())) { // TC: O(S + K)
                indegrees.put(v, indegrees.getOrDefault(v, 0) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                    canBePrepared.add(v);
                }
            }
        }
        for (String rec : recipes) { // TC: O(N)
            if (canBePrepared.contains(rec)) { // TC: O(1)
                result.add(rec);
            }
        }
        return result;
    }
}
