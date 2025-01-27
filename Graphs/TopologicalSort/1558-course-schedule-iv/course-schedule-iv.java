class Solution {
    /**
     * Using Kahn's Algorithm (Topological Sort in DAGs)
     *
     * TC: O(V ^ 2 + V + E + Q)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
        int[][] queries) {
        int q = queries.length;
        List<Boolean> result = new ArrayList<Boolean>();
        if (prerequisites.length == 0) {
            result = new ArrayList<Boolean>(Arrays.asList(new Boolean[q]));
            Collections.fill(result, Boolean.FALSE);
            return result;
        }
        int[] indegrees = new int[numCourses]; // SC: O(V)
        // Create Adjacency List
        Map<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : prerequisites) {
            adj.putIfAbsent(edge[0], new ArrayList<Integer>());
            adj.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }
        // Performing Topological Sorting by Kahn's Algorithm (BFS) - TC: O(V + E)
        Map<Integer, HashSet<Integer>> depMap = topoSort(adj, indegrees);
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int src = queries[i][0];
            int des = queries[i][1];
            result.add(depMap.getOrDefault(des, new HashSet<Integer>()).contains(src));
        }
        return result;
    }

    /**
     * Using Kahn's Algorithm (Topological Sort in DAGs)
     *
     * TC: O(V + E)
     * SC: O(V)
     */
    private Map<Integer, HashSet<Integer>> topoSort(Map<Integer,
        ArrayList<Integer>> adj, int[] indegrees) {
        Map<Integer, HashSet<Integer>> dep = new HashMap<Integer, HashSet<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            // TC: O(V ^ 2)
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                // adding the pre-requisites to its followers
                dep.computeIfAbsent(v, k -> new HashSet<Integer>()).add(u);
                dep.get(v).addAll(dep.getOrDefault(u, new HashSet<Integer>()));
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return dep;
    }
}
