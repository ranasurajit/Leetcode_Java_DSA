class Solution {
    /**
     * Approach : Using String + Two Pointers Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        }
        if (m == n && haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < m - n + 1; i++) { // TC: O(M)
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) { // TC: O(N)
                j++;
            }
            if (j == n) {
                // we found the match
                return i;
            }
        }
        return -1;
    }
}
