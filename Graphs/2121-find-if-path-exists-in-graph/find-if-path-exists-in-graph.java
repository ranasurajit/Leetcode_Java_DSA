class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        // return dfsGraph(adjList, visited, source, destination);
        if (!visited[source] && bfsGraph(adjList, visited, source, destination)) {
            return true;
        }
        return false;
    }

    /**
     * DFS Traversal
     */ 
    private boolean dfsGraph(ArrayList<ArrayList<Integer>>adjList, boolean[] visited, 
        int source, int destination) {
        // Base condition
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (Integer it: adjList.get(source)) {
            if (!visited[it] && dfsGraph(adjList, visited, it, destination)) {
                return true;
            }
        }
        return false;
    }

    /**
     * BFS Traversal
     */ 
    private boolean bfsGraph(ArrayList<ArrayList<Integer>>adjList, boolean[] visited, 
        int source, int destination) {
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == destination) {
                return true;
            }
            for (Integer it : adjList.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.offer(it);
                }
            }
        }
        return false;
    }
}