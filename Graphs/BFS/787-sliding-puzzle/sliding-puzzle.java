class Solution {
    /**
     * TC : O(6!) - In worst case all states are visited
     * SC : O(6!) - All states are stored in map
     */
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) { // TC: O(2)
            for (int val : row) { // TC: O(3)
                sb.append(val);
            }
        }
        String start = sb.toString();
        String target = "123450";

        // creating the adjacency list
        HashMap<Integer, int[]> adj = new HashMap<Integer, int[]>(); // SC: O(6!)
        adj.put(0, new int[]{1, 3});
        adj.put(1, new int[]{0, 2, 4});
        adj.put(2, new int[]{1, 5});
        adj.put(3, new int[]{0, 4});
        adj.put(4, new int[]{1, 3, 5});
        adj.put(5, new int[]{2, 4 });

        /*
         * The puzzle has 6 ! = 720 possible permutations of the board,
         * as there are 6 tiles, including the blank tile (0). 
         * In the worst case, BFS explores all permutations.
         */
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);

        // BFS
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return level;
                }
                int idxZero = current.indexOf("0");
                for (int swapIdx : adj.get(idxZero)) {
                    char[] currentState = current.toCharArray();
                    // swapping zero with directions
                    char temp = currentState[idxZero];
                    currentState[idxZero] = currentState[swapIdx];
                    currentState[swapIdx] = temp;
                    String newState = String.valueOf(currentState);
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
