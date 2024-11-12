class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int p = n - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        int q = p;
        while (q >= 0 && s.charAt(q) != ' ') {
            q--;
        }
        return p - q;
    }
}
