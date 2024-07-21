class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return topoSort(adj, numCourses);
    }

    private boolean topoSort(HashMap<Integer, ArrayList<Integer>> adj, int n) {
        Stack<Integer> st = new Stack<Integer>();
        int[] visited = new int[n + 1];
        boolean[] hasCycle = { false };
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfsGraph(i, adj, visited, st, hasCycle);
                if (hasCycle[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfsGraph(int u, HashMap<Integer, ArrayList<Integer>> adj,
        int[] visited, Stack<Integer> st, boolean[] hasCycle) {
        visited[u] = 1;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == 0) {
                dfsGraph(v, adj, visited, st, hasCycle);
            } else if (visited[v] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        st.push(u);
        visited[u] = 2;
    }
}
