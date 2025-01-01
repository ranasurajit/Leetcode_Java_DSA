class Solution {
    /**
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxScore(String s) {
        int n = s.length();
        // pre-processing count of zero's from left and one's from right
        int[] zeros = new int[n];          // SC: O(N)
        int[] ones = new int[n];           // SC: O(N)
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {      // TC: O(N)
            int count = s.charAt(i) == '0' ? 1 : 0;
            zeros[i] = zeros[i - 1] + count;
        }
        ones[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            int count = s.charAt(i) == '1' ? 1 : 0;
            ones[i] = ones[i + 1] + count;
        }
        int maxScore = 0;
        int current = 0;
        for (int i = 1; i < n; i++) {      // TC: O(N)
            current = zeros[i - 1] + ones[i];
            maxScore = Math.max(maxScore, current);
        }
        return maxScore;
    }
}
