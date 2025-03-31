class Solution {
    /**
     * Using Geedy Approach and Sorting
     *
     * TC: O(N + K + N x Log(N)) ~ O(K + N x Log(N))
     * SC: O(N)
     */
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] pairSum = new long[n - 1]; // SC: O(N)
        for (int i = 1; i < n; i++) { // TC: O(N)
            pairSum[i - 1] = (long) weights[i - 1] + (long) weights[i];
        }
        Arrays.sort(pairSum); // TC: O(N x Log(N))
        // we need to pick the (k - 1) pairs for k bags
        long minimumScores = 0;
        long maximumScores = 0;
        for (int i = 0; i < k - 1; i++) { // TC: O(K)
            minimumScores += pairSum[i];
            maximumScores += pairSum[n - i - 2];
        }
        return maximumScores - minimumScores;
    }
}
