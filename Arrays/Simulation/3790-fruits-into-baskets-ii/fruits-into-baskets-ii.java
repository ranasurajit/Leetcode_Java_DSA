class Solution {
    /**
     * Approach : Using Array Simulation Approach
     *
     * TC: O(N x N)
     * SC: O(1)
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int countUnplaced = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int notset = 1;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (fruits[i] == -1 || baskets[j] == -1) {
                    continue;
                }
                if (fruits[i] <= baskets[j]) {
                    fruits[i] = -1;
                    baskets[j] = -1;
                    notset = 0;
                }
            }
            countUnplaced += notset;
        }
        return countUnplaced;
    }
}
