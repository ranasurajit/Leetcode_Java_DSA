class Solution {
    /**
     * Approach II : Using KMP Algorith (LPS Array + Two Pointers) Approach
     *
     * TC: O(M + N)
     * SC: O(N)
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        /**
         * we will be using KMP algorithm to solev this
         * 1. We will create LPS array of pattern i.e. String needle
         * 2. We will perform Two Pointers approach using LPS array
         *
         * where LPS = Longest Prefix Suffix
         */
        int[] lps = computeLPS(needle, n); // TC: O(N), SC: O(N)
        // Using Two Pointers Approach
        int i = 0; // pointer at the start of String 'haystack'
        int j = 0; // pointer at the start of String 'needle'
        while (i < m) { // TC: O(M)
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    // we found the match
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    /**
     * Using KMP Algorithm
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int[] computeLPS(String s, int n) {
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) { // TC: O(N)
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // we will reduce 'len' to fallback to lps[len - 1]
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Approach I : Using String + Two Pointers (Brute-Force) Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int strStrBruteForce(String haystack, String needle) {
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
