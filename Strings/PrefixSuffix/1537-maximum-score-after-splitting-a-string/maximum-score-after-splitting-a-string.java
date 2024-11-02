class Solution {
    /**
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxScore(String s) {
        int n = s.length();
        int[] prefix = new int[n];         // SC: O(N)
        int[] suffix = new int[n];         // SC: O(N)
        prefix[0] = s.charAt(0) == '0' ? 1 : 0;
        suffix[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {      // TC: O(N)
            prefix[i] = s.charAt(i) == '0' ? 1 + prefix[i - 1] : prefix[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffix[i] = s.charAt(i) == '1' ? 1 + suffix[i + 1] : suffix[i + 1];
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {     // TC: O(N)
            maxScore = Math.max(maxScore, prefix[i - 1] + suffix[i]);
        }
        return maxScore;
    }
}
