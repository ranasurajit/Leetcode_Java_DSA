class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> sortedRow = topoSort(rowConditions, k);
        ArrayList<Integer> sortedCol = topoSort(colConditions, k);
        System.out.println(sortedRow);
        System.out.println(sortedCol);
        int[][] matrix = new int[k][k];
        if (sortedRow.size() == 0 || sortedCol.size() == 0) {
            return new int[][]{};
        }
        HashMap<Integer, Integer> colPosition = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            colPosition.put(sortedCol.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int element = sortedRow.get(i);
            matrix[i][colPosition.get(element)] = element;
        }
        return matrix;
    }

    private ArrayList<Integer> topoSort(int[][] edges, int v) {
        HashMap<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();
        // Creating directed graph (topological sort works only on DAGs)
        for (int i = 0; i < edges.length; i++) {
            if (!adj.containsKey(edges[i][0])) {
                adj.put(edges[i][0], new ArrayList<Integer>());
            }
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        // 0 - not visited, 1 - visit in process, 2 - visited
        int[] visited = new int[v + 1];
        // to detect cycle
        boolean[] hasCycle = { false };
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                dfsGraph(i, visited, st, adj, hasCycle);
                if (hasCycle[0]) {
                    return new ArrayList<Integer>();
                }
            }
        }
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        while (!st.isEmpty()) {
            sorted.add(st.pop());
        }
        return sorted;
    }

    private void dfsGraph(int u, int[] visited, Stack<Integer> st,
        HashMap<Integer, ArrayList<Integer>> adj, boolean[] hasCycle) {
        visited[u] = 1; // visit in progress
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == 0) {
                dfsGraph(v, visited, st, adj, hasCycle);
            } else if (visited[v] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        st.push(u);
        visited[u] = 2; // visited
    }
}
