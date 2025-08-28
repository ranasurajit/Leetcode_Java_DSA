class Solution {
    /**
     * Approach II : Using Array Simulation Approach
     *
     * TC: O(2 x N x N) + O(N x N x log(N)) + O(2 x N x N) + O(N x N x log(N)) ~ O(N ^ 2 x log(N))
     * SC: O(N)
     */
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // handling bottom-left triangle
        for (int i = 0; i < n; i++) { // TC: O(N)
            List<Integer> temp = new ArrayList<Integer>(); // SC: O(N)
            for (int j = 0; i + j < n; j++) { // TC: O(N)
                temp.add(grid[i + j][j]);
            }
            temp.sort(Collections.reverseOrder()); // TC: O(N x log(N))
            for (int j = 0; i + j < n; j++) { // TC: O(N)
                grid[i + j][j] = temp.get(j);
            }
        }
        // handling top-right triangle
        for (int j = 1; j < n; j++) { // TC: O(N)
            List<Integer> temp = new ArrayList<Integer>(); // SC: O(N) - reused
            for (int i = 0; j + i < n; i++) { // TC: O(N)
                temp.add(grid[i][j + i]);
            }
            Collections.sort(temp); // TC: O(N x log(N))
            for (int i = 0; j + i < n; i++) { // TC: O(N)
                grid[i][j + i] = temp.get(i);
            }
        }
        return grid;
    }

    /**
     * Approach I : Using Array Simulation + Hashing Approach
     *
     * TC: O(N x N) + O(2 x N x N x log(N)) + O(N x N x N) ~ O(N ^ 3)
     * SC: O(2 x N) ~ O(N)
     */
    public int[][] sortMatrixUsingHashingSort(int[][] grid) {
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
