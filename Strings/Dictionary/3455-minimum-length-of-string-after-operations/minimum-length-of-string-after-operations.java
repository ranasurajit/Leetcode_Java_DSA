class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int minimumLength(String s) {
        int n = s.length();
        int[] alpha = new int[26];    // SC: O(26) ~ O(1) 
        for (int i = 0; i < n; i++) { // TC: O(N)
            alpha[s.charAt(i) - 'a']++;
        }
        int minLength = 0;
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            if (alpha[i] > 2) {
                minLength += alpha[i] % 2 == 0 ? 2 : 1;
            } else {
                minLength += alpha[i];
            }
        }
        return minLength;
    }
}
