class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(M + N)
     * SC: O(1)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26]; // SC: O(26) ~ O(1)
        for (char ch : ransomNote.toCharArray()) { // TC: O(M)
            map[ch - 'a']++;
        }
        for (char ch : magazine.toCharArray()) { // TC: O(N)
            map[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            if (map[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
