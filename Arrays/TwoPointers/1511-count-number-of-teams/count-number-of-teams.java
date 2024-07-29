class Solution {
    public int numTeams(int[] rating) {
        // we need to find rating such that i << j << k or i >> j >> k
        int n = rating.length;
        int teams = 0;

        for (int j = 1; j < n - 1; j++) {
            // j will never reach index 0 or n - 1
            int smallerLeft = 0;
            int largerLeft = 0;
            int largerRight = 0;
            int smallerRight = 0;
            for (int i = 0; i < j; i++) {
                // count elements left of j
                if (rating[i] < rating[j]) {
                    smallerLeft++;
                } else if (rating[i] > rating[j]) {
                    largerLeft++;
                }
            }
            for (int k = j + 1; k < n; k++) {
                // count elements right of j
                if (rating[k] < rating[j]) {
                    smallerRight++;
                } else if (rating[k] > rating[j]) {
                    largerRight++;
                }
            }
            // strictly increasing elements
            teams += (smallerLeft * largerRight);
            // strictly decreasing elements
            teams += (largerLeft * smallerRight);
        }
        return teams;
    }
}
