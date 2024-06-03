class Solution {
    public int appendCharacters(String s, String t) {
        int p = 0;
        int q = 0;
        int plen = s.length();
        int tlen = t.length();
        while (p < plen && q < tlen) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        int count = 0;
        if (q == tlen) {
            return count;
        }
        while (q < tlen) {
            q++;
            count++;
        }
        return count;
    }
}
