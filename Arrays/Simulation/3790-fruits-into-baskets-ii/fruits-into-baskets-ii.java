class Solution {
    /**
     * Approach : Using Sorting + Two Pointers Approach
     *
     * TC: O(N x log(N)) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fruits[i] == -1 || baskets[j] == -1) {
                    continue;
                }
                if (fruits[i] <= baskets[j]) {
                    fruits[i] = -1;
                    baskets[j] = -1;
                }
            }
        }
        int countUnplaced = 0;
        for (int i = 0; i < n; i++) {
            if (fruits[i] != -1) {
                countUnplaced++;
            }
        }
        return countUnplaced;
    }
}
