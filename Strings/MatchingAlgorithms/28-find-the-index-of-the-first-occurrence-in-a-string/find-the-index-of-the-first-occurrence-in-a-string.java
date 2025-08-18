class Solution {
    /**
     * Approach II : Using Z-Algorithm Approach
     *
     * TC: O(N + M)
     * SC: O(N)
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        String text = needle + "$" + haystack;
        int n = text.length();
        int offset = m + 1;
        int[] zArr = computeZArray(text, n); // TC: O(N + M), SC: O(N + M)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (zArr[i] == m) {
                return i - offset;
            }
        }
        return -1;
    }

    private int[] computeZArray(String text, int n) {
        int[] zArr = new int[n]; // SC: O(N)
        int left = 0;
        int right = 0;
        for (int k = 1; k < n; k++) { // TC: O(N)
            if (k > right) {
                left = k;
                right = k;
                while (right < n && text.charAt(right) == text.charAt(right - left)) {
                    right++;
                }
                zArr[k] = right - left;
                right--;
            } else {
                int k1 = k - left;
                if (zArr[k1] < right - k + 1) {
                    zArr[k] = zArr[k1];
                } else {
                    left = k;
                    while (right < n && text.charAt(right) == text.charAt(right - left)) {
                        right++;
                    }
                    zArr[k] = right - left;
                    right--;
                }
            }
        }
        return zArr;
    }

    /**
     * Approach I : Using KMP Algorithm Approach
     *
     * TC: O(N + M)
     * SC: O(N)
     */
    public int strStrUsingKMP(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        /**
         * we will compute LPS (Longest Prefix Suffix) on the pattern 
         * String i.e. on needle
         */
        int[] lps = computeLPS(needle, n); // TC: O(N), SC: O(N)
        /**
         * we will use Two Pointers Approach to find the pattern 
         * i.e. needle in String 'haystack'
         */
        int i = 0; // pointer at the start of String 'haystack'
        int j = 0; // pointer at the start of String 'needle'
        while (i < m) { // TC: O(M)
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - j;
                }
            } else {
                // we will fallback j to lps[j - 1]
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
     * Using LPS (Longest Prefix Suffix) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int[] computeLPS(String s, int n) {
        int[] lps = new int[n]; // SC: O(N)
        int len = 0;
        int i = 1;
        while (i < n) { // TC: O(N)
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // we will fallback 'len' to lps[len - 1]
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
}
