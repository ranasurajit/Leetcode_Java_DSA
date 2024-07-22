class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        createGraph(prerequisites, adj, numCourses);
        int[] indegrees = getIndegrees(prerequisites, numCourses);
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] order = new int[numCourses];
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            order[index++] = u;
            for (Integer v : adj.get(u)) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return order;
    }

    private void createGraph(int[][] prerequisites,
        HashMap<Integer, ArrayList<Integer>> adj, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }

    private int[] getIndegrees(int[][] prerequisites, int numCourses) {
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }
        return indegrees;
    }
}
