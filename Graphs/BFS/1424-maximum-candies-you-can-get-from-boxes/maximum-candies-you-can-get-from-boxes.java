class Solution {
    /**
     * Approach : Using BFS Approach
     *
     * TC: O(N ^ 2) 
     * SC: O(2 x N) ~ O(N)
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys,
        int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        int maxCandies = 0;
        boolean[] visited = new boolean[n];      // SC: O(N)
        Queue<Integer> queue = new LinkedList(); // SC: O(N)
        for (int box : initialBoxes) { // TC: O(N)
            if (status[box] == 1) {
                // box is open
                queue.offer(box);
            } else {
                // box is closed, will open once key is found, so mark it as visited
                visited[box] = true;
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                maxCandies += candies[u];
                for (int v : containedBoxes[u]) { // TC: O(N)
                    if (status[v] == 1) {
                        // box is open
                        queue.offer(v);
                    } else {
                        // box is closed, will open once key is found, so mark it as visited
                        visited[v] = true;
                    }
                }
                for (int key : keys[u]) { // TC: O(N)
                    if (visited[key] && status[key] == 0) {
                        queue.offer(key);
                    }
                    status[key] = 1;
                }
            }
        }
        return maxCandies;
    }
}
