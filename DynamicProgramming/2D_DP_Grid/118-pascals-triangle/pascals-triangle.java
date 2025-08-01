class Solution {
    /**
     * Approach II : Using Dynamic Programming (Tabulation) Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        // Initialization
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        // Iterative Calls
        for (int row = 1; row < numRows; row++) { // TC: O(N x (N + 1)) / 2
            List<Integer> current = new ArrayList<Integer>();
            List<Integer> prev = triangle.get(row - 1);
            // first cell is 1 always
            current.add(1);
            for (int cell = 1; cell < row; cell++) {
                current.add(prev.get(cell - 1) + prev.get(cell));
            }
            // last cell is 1 always
            current.add(1);
            triangle.add(current);
        }
        return triangle;
    }

    /**
     * Approach I : Using Array Simulation Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public List<List<Integer>> generateBruteForce(int numRows) {
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
