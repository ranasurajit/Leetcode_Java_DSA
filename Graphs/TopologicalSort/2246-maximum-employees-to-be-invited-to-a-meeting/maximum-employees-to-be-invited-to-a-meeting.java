class Solution {
    /**
     * Using Toplogical Sort (BFS - Kahn's Algorithm) + Normal BFS
     *
     * TC: O(V + E)
     * SC: O(V)
     */
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> reverseAdj = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            reverseAdj.add(new ArrayList<Integer>());
        }
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            reverseAdj.get(favorite[i]).add(i);
            indegrees[favorite[i]]++;
        }
        int totalTailLength = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && indegrees[i] == 0) {
                int node = topologicalSort(favorite, indegrees, visited, i);
                if (favorite[favorite[node]] == node) {
                    // 2 length cycle
                    int tailLength = maxDepthBFS(reverseAdj, 
                        visited, n, node, favorite[node]) - 1;
                    totalTailLength += tailLength;
                    visited[node] = false;
                }
            }
        }
        int twoSizeCycles = 0;
        int maxCycleSize = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleSize = getCycleSizeBFS(favorite, visited, i);
                if (cycleSize == 2) {
                    twoSizeCycles++;
                } else {
                    maxCycleSize = Math.max(maxCycleSize, cycleSize);
                }
            }
        }
        int cycleSizeII = totalTailLength + 2 * twoSizeCycles;
        return Math.max(cycleSizeII, maxCycleSize);
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private int getCycleSizeBFS(int[] adj, boolean[] visited, int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited[source] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (!visited[adj[u]]) {
                visited[adj[u]] = true;
                queue.offer(adj[u]);
            }
            count++;
        }
        return count;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private int maxDepthBFS(List<List<Integer>> reverseAdj, boolean[] origVisited,
        int n, int source, int avoid) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited[source] = true;
        visited[avoid] = true;
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                origVisited[u] = true;
                for (Integer v : reverseAdj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
            levels++;
        }
        return levels;
    }

    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private int topologicalSort(int[] adj, int[] indegrees,
        boolean[] visited, int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        int lastNode = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            lastNode = u;
            int v = adj[u];
            indegrees[v]--;
            if (!visited[v] && indegrees[v] == 0) {
                queue.offer(v);
            }
        }
        return adj[lastNode];
    }
}
