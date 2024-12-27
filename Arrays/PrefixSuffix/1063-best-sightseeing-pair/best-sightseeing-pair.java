class Solution {
    /**
     * Optimal Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxTillNow = values[0] + 0;
        int maxScore = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {   // TC: O(N)
            maxScore = Math.max(maxScore, maxTillNow + values[j] - j);
            maxTillNow = Math.max(maxTillNow, values[j] + j);
        }
        return maxScore;
    }
}
