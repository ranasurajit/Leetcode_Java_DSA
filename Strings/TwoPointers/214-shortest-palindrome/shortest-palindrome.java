class Solution {
    /**
     * TC: O(5N) ~ O(N)
     * SC: O(N)
     */
    public String shortestPalindrome(String s) {
        String t = reverse(s); // TC: O(N)
        String p = s + "#" + t; // TC: O(N)
        int[] lps = new int[p.length()]; // SC: O(N)
        int longestPalin = getLongestPalindrome(lps, p); // TC: O(N)
        String portion = s.substring(longestPalin); // TC: O(N)
        return reverse(portion) + s; // TC: O(N)
    }

    /**
     * Get longest palindrome
     *
     * TC: O(N)
     * SC: O(1)
     */
    private int getLongestPalindrome(int[] lps, String p) {
        int i = 0;
        int j = 1;
        int n = p.length();
        while (j < n) {
            if (p.charAt(i) == p.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps[n - 1];
    }

    /**
     * Get reverse of a String
     * TC: O(N)
     * SC: O(1)
     */
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
}
