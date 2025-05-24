class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N ^ 2) ~ O(N ^ 2)
     * SC: O(N ^ 2 + N) ~ O(N ^ 2)
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<String, Integer>(); // SC: O(N)
        for (int[] row : grid) { // TC: O(N)
            StringBuilder sb = new StringBuilder(); // SC: O(N)
            for (int col : row) { // TC: O(N)
                sb.append(col);
                sb.append('-');
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int j = 0; j < n; j++) { // TC: O(N)
            StringBuilder sb = new StringBuilder(); // SC: O(N)
            for (int i = 0; i < n; i++) { // TC: O(N)
                sb.append(grid[i][j]);
                sb.append('-');
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                count += map.get(key) == 1 ? 1 : map.get(key);
            }
        }
        return count;
    }
}
