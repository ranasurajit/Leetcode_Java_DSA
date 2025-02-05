class Solution {
    /**
     * Approach 2
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int i = 0;
        int j = 0;
        int count = 0;
        for (int p = 0; p < n; p++) { // TC: O(N)
            if (s1.charAt(p) != s2.charAt(p)) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    if (count == 1) {
                        i = p;
                    } else {
                        j = p;
                    }
                }
            }
        }
        // chcek if the replaceable indices have same Characters
        return (s1.charAt(i) == s2.charAt(j)) && (s2.charAt(i) == s1.charAt(j));
    }

    /**
     * Approach 1 : Using Hashing and Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public boolean areAlmostEqualApproach1(String s1, String s2) {
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
