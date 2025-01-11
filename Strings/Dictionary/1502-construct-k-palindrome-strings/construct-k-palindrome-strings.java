class Solution {
    /**
     * TC: O(N)
     * SC: O(26) ~ O(1)
     */
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n) {
            return false;
        }
        if (k == n) {
            return true;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < n; i++) {  // TC: O(N)
            alpha[s.charAt(i) - 'a']++;
        }
        int oddCharsCount = 0;
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (alpha[i] % 2 != 0) {
                // number of odd characters decides how many palindromes can be created
                oddCharsCount++;
            }
        }
        return oddCharsCount <= k;
    }
}
