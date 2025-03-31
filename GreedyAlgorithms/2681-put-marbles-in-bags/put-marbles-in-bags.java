class Solution {
    /**
     * Using Geedy Approach and Sorting
     *
     * TC: O(N + K + N x Log(N)) ~ O(K + N x Log(N))
     * SC: O(N)
     */
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Long> pairSum = new ArrayList<Long>(); // SC: O(N)
        for (int i = 1; i < n; i++) { // TC: O(N)
            pairSum.add((long) weights[i - 1] + (long) weights[i]);
        }
        Collections.sort(pairSum, Comparator.comparingLong(a -> a)); // TC: O(N x Log(N))
        // we need to pick the (k - 1) pairs for k bags
        long minimumScores = 0;
        long maximumScores = 0;
        for (int i = 0; i < k - 1; i++) { // TC: O(K)
            minimumScores += pairSum.get(i);
            maximumScores += pairSum.get(n - i - 2);
        }
        return maximumScores - minimumScores;
    }
}
