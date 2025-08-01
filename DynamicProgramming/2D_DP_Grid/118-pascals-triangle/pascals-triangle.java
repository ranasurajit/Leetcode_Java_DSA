class Solution {
    /**
     * Approach I : Using Array Simulation Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) { // TC: O(N x (N + 1)) / 2
            triangle.add(new ArrayList<Integer>());
            for (int j = 0; j < i; j++) {
                triangle.get(i - 1).add(1);
                if (j == 0 || j == i - 1) {
                    continue;
                }
                triangle.get(i - 1).set(j, triangle.get(i - 2).get(j - 1) + triangle.get(i - 2).get(j));
            }
        }
        return triangle;
    }
}
