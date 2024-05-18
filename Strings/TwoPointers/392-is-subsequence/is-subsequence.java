class Solution {
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        int sLen = s.length();
        int q = 0;
        int tLen = t.length();
        while (p < sLen && q < tLen) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
                q++;
            } else {
                q++;
            }
        }
        if (p < sLen) {
            return false;
        }
        return true;
    }
}
