class Solution {
    /**
     * Approach : Using Longest Prefix Suffix Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n]; // SC: O(N)
        int len = 0;
        int i = 1;
        int startIdx = -1;
        while (i < n) {
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // fallback len to lps[len - 1]
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0, lps[n - 1]);
    }
}
