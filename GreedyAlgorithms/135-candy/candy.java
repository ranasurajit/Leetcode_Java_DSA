class Solution {
    /**
     * Approach I : Using Greedy + Array Pre-processing Approach
     *
     * TC: O(N) + O(N) + O(N) ~ O(N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        // pre-processing candy allocation from left to right
        int[] leftAlloc = new int[n];      // SC: O(N)
        leftAlloc[0] = 1;
        for (int i = 1; i < n; i++) {      // TC: O(N)
            if (ratings[i] > ratings[i - 1]) {
                leftAlloc[i] = 1 + leftAlloc[i - 1];
            } else {
                leftAlloc[i] = 1;
            }
        }
        // pre-processing candy allocation from right to left
        int[] rightAlloc = new int[n];     // SC: O(N)
        rightAlloc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            if (ratings[i] > ratings[i + 1]) {
                rightAlloc[i] = 1 + rightAlloc[i + 1];
            } else {
                rightAlloc[i] = 1;
            }
        }
        int totalCandies = 0;
        // summing up all candies
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalCandies += Math.max(leftAlloc[i], rightAlloc[i]);
        }
        return totalCandies;
    }
}
