class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int minimumLength(String s) {
        int n = s.length();
        int p = 0;     // pointer at the start of String s
        int q = n - 1; // pointer at the end of String s
        while (p < q && s.charAt(p) == s.charAt(q)) { // TC: O(N)
            char ch = s.charAt(p);
            while (p < q && s.charAt(p) == ch) {
                p++;
            }
            while (q >= p && s.charAt(q) == ch) {
                q--;
            }
        }
        return q - p + 1;
    }
}
