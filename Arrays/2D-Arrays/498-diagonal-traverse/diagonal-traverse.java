class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int size = rows * cols;
        int[] result = new int[size];
        Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!hm.containsKey(i + j)) {
                    hm.put((i + j), new ArrayList<Integer>());
                }
                if ((i + j) % 2 == 0) {
                    hm.get(i + j).add(0, mat[i][j]);
                } else {
                    hm.get(i + j).add(mat[i][j]);
                }
            }
        }
        int count = 0;
        for (Integer key : hm.keySet()) {
            for (Integer it : hm.get(key)) {
                result[count] = it;
                count++;
            }
        }
        return result;
    }
}
