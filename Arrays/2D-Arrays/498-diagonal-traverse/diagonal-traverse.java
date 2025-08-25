class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(M x N) + O(M x N) ~ O(M x N)
     * SC: O(M x N) + O(M x N) ~ O(M x N)
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n]; // SC: O(M x N)
        Map<Integer, ArrayList<Integer>> map =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(M x N)
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                map.computeIfAbsent(i + j, k -> new ArrayList<Integer>()).add(mat[i][j]);
            }
        }
        int index = 0;
        for (int i = 0; i <= m + n - 2; i++) { // TC: O(M x N)
            ArrayList<Integer> list = map.get(i);
            if ((i & 1) == 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    result[index++] = list.get(j);
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    result[index++] = list.get(j);
                }
            }
        }
        return result;
    }
}
