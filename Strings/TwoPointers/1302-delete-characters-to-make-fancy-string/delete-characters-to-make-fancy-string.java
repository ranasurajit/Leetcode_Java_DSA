class Solution {
    /**
     * Optimized Approach
     * TC: O(N)
     * SC: O(N)
     */
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) { // TC: O(N), SC: O(N)
            int n = sb.length();
            if (n < 2 || !(sb.charAt(n - 1) == ch && sb.charAt(n - 2) == ch)) {
                sb.append(ch); // TC: O(1)
            }
        }
        return sb.toString();
    }

    /**
     * Using Two Pointers Approach
     * TC: O(3N) ~ O(N)
     * SC: O(N)
     */
    public String makeFancyStringTwoPointers(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray(); // TC: O(N), SC: O(N)
        int n = ch.length;
        int p = 0, q = 1, r = 2;
        while (r < n) {     // TC: O(N)
            if (ch[p] == ch[q] && ch[q] == ch[r]) {
                ch[p] = '0';
            }
            p++;
            q++;
            r++;
        }
        for (char c : ch) { // TC: O(N)
            if (c != '0') {
                sb.append(c); // TC: O(1)
            }
        }
        return sb.toString();
    }
}
