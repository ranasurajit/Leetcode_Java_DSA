class Solution {
    /**
     * Approach II : Using Greedy + Array Pre-processing (Better Approach / Less Memory) Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
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
        // we will be computing sum and right allocation on the fly
        int current = 1;
        int right = 1;
        int totalCandies = Math.max(1, leftAlloc[n - 1]);
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            if (ratings[i] > ratings[i + 1]) {
                current = right + 1;
            } else {
                current = 1;
            }
            totalCandies += Math.max(current, leftAlloc[i]);
            right = current;
        }
        return totalCandies;
    }

    /**
     * Approach I : Using Greedy + Array Pre-processing Approach
     *
     * TC: O(N) + O(N) + O(N) ~ O(N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public int candyBruteForce(int[] ratings) {
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
