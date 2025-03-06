class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(2 x N x N) ~ O(N x N)
     * SC: O(N x N)
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N x N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int[] result = new int[2];
        for (int i = 1; i <= n * n; i++) { // TC: O(N ^ 2)
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    result[0] = i;
                }
            } else {
                result[1] = i;
            }
        }
        return result;
    }
}
