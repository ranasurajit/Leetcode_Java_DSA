class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public String makeFancyString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int p = 0, q = 1, r = 2;
        StringBuilder sb = new StringBuilder();
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
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
