class Solution {
    /**
     * Approach : Using Array Simulation + Hashing Approach
     *
     * TC: O(N x N) + O(2 x N x N x log(N)) + O(N x N x N) ~ O(N ^ 3)
     * SC: O(2 x N) ~ O(N)
     */
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(); // SC: O(2 x N)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                map.computeIfAbsent(i - j, k -> new ArrayList<Integer>()).add(grid[i][j]);
            }
        }
        for (Integer key : map.keySet()) { // TC: O(2 x N)
            if (key < 0) {
                Collections.sort(map.get(key)); // TC: O(N x log(N))
            } else {
                map.get(key).sort(Collections.reverseOrder()); // TC: O(N x log(N))
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                int key = i - j;
                List<Integer> list = map.get(key);
                grid[i][j] = list.get(0);
                list.remove(0); // TC: O(N)
            }
        }
        return grid;
    }
}
