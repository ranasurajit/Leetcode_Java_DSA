class Solution {
    /**
     * Approach : Using Topological Sort (Kahn's Algorithm) + Dynamic Programming Approach
     *
     * TC: O(M + 2 x N) ~ O(M + N)
     * SC: O(M + 3 x N) ~ O(M + N)
     *
     * where M = Length(edges), N = Length(colors)
     */
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegrees = new int[n]; // SC: O(N)
        Map<Integer, ArrayList<Integer>> adj = createGraph(edges, indegrees); // SC: O(M)
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[][] dp = new int[n][26]; // SC: O(26 x N) ~ O(N)
        int visitedNodes = 0;
        int result = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            Arrays.fill(dp[i], 0);
            while (!queue.isEmpty()) { // TC: O(N + M)
                Integer u = queue.poll();
                visitedNodes++;
                int color = colors.charAt(u) - 'a';
                dp[u][color]++;
                result = Math.max(result, dp[u][color]);
                for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                    for (int j = 0; j < 26; j++) {
                        dp[v][j] = Math.max(dp[v][j], dp[u][j]);
                    }
                    if (--indegrees[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }
        return visitedNodes == n ? result : -1;
    }

    /**
     * Creating Adjacency List from edges and forming indegrees
     *
     * TC: O(M)
     * SC: O(1)
     *
     * where M = Length(edges)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] edges, int[] indegrees) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) { // TC: O(M)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            indegrees[edge[1]]++;
        }
        return adj;
    }
}
