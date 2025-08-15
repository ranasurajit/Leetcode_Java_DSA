class Solution {
    /**
     * Approach III : Using KMP Algorithm Approach
     *
     * TC: O(M + N)
     * SC: O(N)
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] lps = computeLPS(needle, n); // SC: O(N) - longest prefix suffix array on pattern String
        // now using Two Pointers Approach
        int i = 0; // pointer at the start of String 'haystack'
        int j = 0; // pointer at the start of String 'needle'
        while (i < m && j < n) { // TC: O(M + N)
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    // we found a match at index 'i - j'
                    return i - j;
                }
            } else {
                // we need to fallback j to lps[j - 1] and i will continue its journey
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
     * Using Computation of Longest Prefix Suffix Array Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int[] computeLPS(String s, int n) {
        int[] lps = new int[n];
        int i = 1;
        int len = 0;
        while (i < n) {
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // we need to fallback len to lps[len - 1]
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Approach II : Using Two Pointers Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int strStrUsingTwoPointers(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m || (n == m && !haystack.equals(needle))) {
            return -1;
        }
        for (int i = 0; i < m - n + 1; i++) { // TC: O(M - N + 1)
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

    /**
     * Approach I : Using Brute-Force (String Simulation) Approach
     *
     * TC: O(M x N)
     * SC: O(N)
     */
    public int strStrUsingBruteForce(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m || (n == m && !haystack.equals(needle))) {
            return -1;
        }
        for (int i = 0; i < m - n + 1; i++) { // TC: O(M - N + 1)
            if (haystack.substring(i, i + n).equals(needle)) { // TC: O(N)
                return i;
            }
        }
        return -1;
    }
}
