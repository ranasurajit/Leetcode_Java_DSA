class Solution {
    /**
     * Approach III : Using Bit Manipulation Approach
     *
     * TC: O(N x N)
     * SC: O(N x N)
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean[] visited = new boolean[n * n + 1]; // SC: O(N x N)
        int repeated = 0;
        int xorAll = 0;
        int xorCount = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {      // TC: O(N)
            for (int j = 0; j < n; j++) {  // TC: O(N)
                xorAll ^= grid[i][j];
                xorCount ^= count;
                count++;
                if (repeated == 0) {
                    if (visited[grid[i][j]]) {
                        repeated = grid[i][j];
                    } else {
                        visited[grid[i][j]] = true;
                    }
                }
            }
        }
        int[] result = new int[2];
        result[0] = repeated;
        int missing = xorAll ^ xorCount ^ repeated;
        result[1] = missing;
        return result;
    }

    /**
     * Approach II : Using Array as Hashing Approach
     *
     * TC: O(2 x N x N) ~ O(N x N)
     * SC: O(N x N)
     */
    public int[] findMissingAndRepeatedValuesApproachII(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];   // SC: O(N x N)
        for (int i = 0; i < n; i++) {      // TC: O(N)
            for (int j = 0; j < n; j++) {  // TC: O(N)
                freq[grid[i][j]]++;
            }
        }
        int[] result = new int[2];
        for (int i = 1; i <= n * n; i++) { // TC: O(N x N)
            if (freq[i] == 2) {
                result[0] = i;
            } else if (freq[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N x N) ~ O(N x N)
     * SC: O(N x N)
     */
    public int[] findMissingAndRepeatedValuesApproachI(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N x N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int[] result = new int[2];
        for (int i = 1; i <= n * n; i++) { // TC: O(N x N)
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
