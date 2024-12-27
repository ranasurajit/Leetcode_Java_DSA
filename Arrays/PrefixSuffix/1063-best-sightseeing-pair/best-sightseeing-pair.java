class Solution {
    /**
     * Using Array Pre-processing
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] maxValIndex = new int[n]; // SC: O(N)
        maxValIndex[0] = values[0] + 0;
        for (int i = 1; i < n; i++) {   // TC: O(N)
            maxValIndex[i] = Math.max(maxValIndex[i - 1], values[i] + i);
        }
        int maxScore = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {   // TC: O(N)
            maxScore = Math.max(maxScore, maxValIndex[j - 1] + values[j] - j);
        }
        return maxScore;
    }

    /**
     * Using DP Approach
     *
     * TC: O(N x K)
     * SC: O(N)
     */
    public int maxScoreSightseeingPairDP(int[] values) {
        int n = values.length;
        int[] maxScore = new int[n]; // SC: O(N)
        maxScore[1] = values[1] + values[0] + 0 - 1; // best answer till index 1
        // maxScore[2] = Math.max(maxScore[1], Math.max(
        //     values[2] + values[0] + 0 - 2,
        //     values[2] + values[1] + 1 - 2
        // ));                                       // best answer till index 2
        for (int i = 2; i < n; i++) {     // TC: O(N)
            maxScore[i] = maxScore[i - 1];
            for (int j = 0; j < i; j++) { // TC: O(K)
                maxScore[i] = Math.max(maxScore[i], values[i] + values[j] + j - i);
            }
        }
        return maxScore[n - 1];
    }

    /**
     * Using Brute-Force Approach
     *
     * TC: O(N x N)
     * SC: O(1)
     */
    public int maxScoreSightseeingPairBruteForce(int[] values) {
        int n = values.length;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                maxScore = Math.max(maxScore, values[i] + values[j] + i - j);
            }
        }
        return maxScore;
    }
}
