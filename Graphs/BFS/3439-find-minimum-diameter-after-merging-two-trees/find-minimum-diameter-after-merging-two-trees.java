class Solution {
    /**
     * TC: O(2 x (V + E)) ~ O(V + E)
     * SC: O(2 x (V + E)) ~ O(V + E)
     */
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dia1 = findDiameter(edges1);
        int dia2 = findDiameter(edges2);
        int radius1 = (dia1 + 1) / 2;
        int radius2 = (dia2 + 1) / 2;
        int sum = 1 + radius1 + radius2;
        return Math.max(sum, Math.max(dia1, dia2));
    }

    /**
     * TC: O(2 x (V + E)) ~ O(V + E)
     * SC: O(2 x (V + E)) ~ O(V + E)
     */
    private int diameter(Map<Integer, List<Integer>> adj, int n) {
        // pick any node say node '0' and find farthest node from it
        int farthestNode = bfsGraph(0, adj, n, true);
        int dia = bfsGraph(farthestNode, adj, n, false) - 1;
        return dia;
    }

    /**
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private int bfsGraph(int startNode, Map<Integer, List<Integer>> adj, int n, boolean farthest) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        queue.offer(startNode);
        visited[startNode] = true;
        int lastNode = startNode;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                visited[u] = true;
                lastNode = u;
                for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
            level++;
        }
        if (farthest) {
            return lastNode;
        }
        return lastNode == startNode ? 1 : level;
    }

    /**
     * TC: O(E)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    private int findDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>(); // SC: O(V + E)
        Set<Integer> nodes = new HashSet<Integer>(); // SC: O(V)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        return diameter(adj, nodes.size());
    }
}
