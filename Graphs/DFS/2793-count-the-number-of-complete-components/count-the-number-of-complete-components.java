class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegrees = new int[n];
        int[] componentIndices = new int[n];
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
            indegrees[edge[1]]++;
            indegrees[edge[0]]++;
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsGraph(i, adj, visited, componentIndices, count);
                count++;
            }
        }
        int incomplete = 0;
        Map<Integer, List<Integer>> compMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            if (!compMap.containsKey(componentIndices[i])) {
                compMap.put(componentIndices[i], 
                    Arrays.asList(0, Integer.MAX_VALUE, Integer.MIN_VALUE));
            }
            compMap.get(componentIndices[i]).
                set(0, compMap.get(componentIndices[i]).get(0) + 1);
            compMap.get(componentIndices[i]).
                set(1, Math.min(compMap.get(componentIndices[i]).get(1), indegrees[i]));
            compMap.get(componentIndices[i]).
                set(2, Math.max(compMap.get(componentIndices[i]).get(1), indegrees[i]));
        }
        for (Integer key : compMap.keySet()) {
            List<Integer> comp = compMap.get(key);
            if (comp.get(1) < comp.get(0) - 1) {
                incomplete++;
            }
        }
        System.out.println(Arrays.toString(indegrees));
        System.out.println(Arrays.toString(componentIndices));
        System.out.println(compMap);
        return count - incomplete;
    }

    private void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, int[] componentIndices, int count) {
        visited[u] = true;
        componentIndices[u] = count;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, componentIndices, count);
            }
        }
    }
}
