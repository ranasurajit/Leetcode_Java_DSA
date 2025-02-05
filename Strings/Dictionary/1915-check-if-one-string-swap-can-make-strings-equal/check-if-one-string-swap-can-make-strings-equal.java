class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int p = 0; // pointer for String 's1'
        int q = 0; // pointer for String 's2'
        int[] chars = new int[26];     // SC: O(1)
        for (int i = 0; i < n; i++) {  // TC: O(N)
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            if (chars[i] != 0) {
                return false;
            }
        }
        int diffIndices = 0;
        while (p < n && q < n) {      // TC: O(N)
            if (s1.charAt(p) != s2.charAt(q)) {
                diffIndices++;
            }
            p++;
            q++;
        }
        return diffIndices <= 2;
    }
}
