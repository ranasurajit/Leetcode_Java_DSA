class Solution {
    /**
     * TC: O(M + N)
     * SC: O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] freq1 = new int[26]; // SC: O(26)
        int[] freq2 = new int[26]; // SC: O(26)
        for (int i = 0; i < m; i++) { // TC: O(M)
            freq1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            freq2[s2.charAt(j) - 'a']++;
            while (j - i + 1 > m) {
                // shrinking the window size of s2 when it's size > s1
                freq2[s2.charAt(i) - 'a']--;
                i++;
            }
            if (Arrays.equals(freq1, freq2)) { // TC: O(26)
                return true;
            }
        }
        return false;
    }
}
