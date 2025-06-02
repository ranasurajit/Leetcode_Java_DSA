class Solution {
    /**
     * Approach I : Using Greedy Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        // calculating the assignment of candies from left to right
        int[] leftAssignment = new int[n]; // SC: O(N)
        leftAssignment[0] = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (ratings[i] > ratings[i - 1]) {
                leftAssignment[i] = leftAssignment[i - 1] + 1;
            } else {
                leftAssignment[i] = 1;
            }
        }
        // calculating the assignment of candies from right to left
        int[] rightAssignment = new int[n]; // SC: O(N)
        rightAssignment[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            if (ratings[i] > ratings[i + 1]) {
                rightAssignment[i] = rightAssignment[i + 1] + 1;
            } else {
                rightAssignment[i] = 1;
            }
        }
        // to satisfy both left and right assignments we need to take the maximum from both sides
        int minimumCandies = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            minimumCandies += Math.max(leftAssignment[i], rightAssignment[i]);
        }
        return minimumCandies;
    }
}
