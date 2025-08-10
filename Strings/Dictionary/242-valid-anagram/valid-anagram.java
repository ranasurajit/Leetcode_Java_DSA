class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N) + O(26) ~ O(N)
     * SC: O(26) ~ O(1)
     */
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        int[] freq = new int[26];      // SC: O(26)
        for (int i = 0; i < n; i++) {  // TC: O(N)
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
