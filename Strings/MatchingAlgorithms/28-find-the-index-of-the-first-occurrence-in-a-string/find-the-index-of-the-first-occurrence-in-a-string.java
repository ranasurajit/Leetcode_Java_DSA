class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     *
     * TC: O(M x N)
     * SC: O(1)
     */
    public int strStr(String haystack, String needle) {
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
    public int strStrBruteForce(String haystack, String needle) {
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
