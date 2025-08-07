class Solution {
    /**
     * Approach : Using Greedy + Dynamic Programming Approach
     *
     * TC: O(N x N) + O(N) + O(N x N) + O(N x N) ~ O(N x N)
     * SC: O(1)
     */
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        // removing the cells which will not be ever visited
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i < j && j < n - 1 - i) {
                    fruits[i][j] = 0;
                }
                if (j < i && i < n - 1 - j) {
                    fruits[i][j] = 0;
                }
            }
        }
        // fixing the movement of child 1 in the diagonal only
        int collection = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            collection += fruits[i][i];
        }
        // tracking for the movement of child 2 in triangle (0, n - 1), (n - 1, 0) and (n - 1, n - 1)
        for (int i = 1; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                fruits[i][j] += Math.max(fruits[i - 1][j - 1], 
                    Math.max(fruits[i - 1][j], j < n - 1 ? fruits[i - 1][j + 1] : 0));
            }
        }
        // tracking for the movement of child 3 in triangle (0, n - 1), (n - 1, 0) and (n - 1, n - 1)
        for (int j = 1; j < n; j++) { // TC: O(N)
            for (int i = j + 1; i < n; i++) { // TC: O(N)
                fruits[i][j] += Math.max(fruits[i - 1][j - 1], 
                    Math.max(fruits[i][j - 1], i < n - 1 ? fruits[i + 1][j - 1] : 0));
            }
        }
        return collection + fruits[n - 2][n - 1] + fruits[n - 1][n - 2];
    }
}
