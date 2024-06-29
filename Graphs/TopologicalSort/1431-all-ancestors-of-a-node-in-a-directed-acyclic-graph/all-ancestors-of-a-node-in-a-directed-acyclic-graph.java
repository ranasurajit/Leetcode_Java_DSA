class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestorsList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<Integer>());
        }
        Map<Integer, ArrayList<Integer>> parentToChild = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, ArrayList<Integer>> childFromParent = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, HashSet<Integer>> ancestors = new HashMap<Integer, HashSet<Integer>>();
        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            if (!parentToChild.containsKey(edge[0])) {
                parentToChild.put(edge[0], new ArrayList<Integer>());
            }
            parentToChild.get(edge[0]).add(edge[1]);
            if (!childFromParent.containsKey(edge[1])) {
                childFromParent.put(edge[1], new ArrayList<Integer>());
            }
            childFromParent.get(edge[1]).add(edge[0]);
            indegrees[edge[1]]++;
        }
        // Doing BFS on nodes with indegree zero (Topological Sort)
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer it = queue.poll();
            HashSet<Integer> result = new HashSet<Integer>();
            for (int ancestor : childFromParent.getOrDefault(it, new ArrayList<Integer>())) {
                result.add(ancestor);
                result.addAll(ancestors.getOrDefault(ancestor, new HashSet<Integer>()));
            }
            ancestors.put(it, result);
            for (Integer child : parentToChild.getOrDefault(it, new ArrayList<Integer>())) {
                indegrees[child]--;
                if (indegrees[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        for (Integer key : ancestors.keySet()) {
            ArrayList<Integer> list = new ArrayList<Integer>(ancestors.get(key));
            Collections.sort(list);
            ancestorsList.get(key).addAll(list);
        }
        return ancestorsList;
    }
}
