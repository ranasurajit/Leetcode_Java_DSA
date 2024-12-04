class Solution {
    /**
     * TC: O(M + N)
     * SC: O(1)
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int p = 0; // pointer for String 'str1'
        int q = 0; // pointer for String 'str2'
        while (p < n && q < m) { // TC: O(M + N)
            if (str1.charAt(p) == str2.charAt(q) || 
                str1.charAt(p) + 1 == str2.charAt(q) ||
                str1.charAt(p) - 25 == str2.charAt(q)) {
                q++;
            }
            p++;
        }
        return q == m;
    }
}
