class Solution {
    /**
     * Minimum number of minutes/operations/characters to remove from start and end is 
     * asked. To tackle we can find the maximum window size from middle such that 
     * count of characters is valid
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] chars = new int[3];
        for (int i = 0; i < n; i++) { // TC: O(N)
            chars[s.charAt(i) - 'a']++;
        }
        if (!isCharsValid(chars, k)) {
            return -1;
        }
        int maxLength = -1;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            chars[s.charAt(j) - 'a']--;
            while (i <= j && !isCharsValid(chars, k)) {
                chars[s.charAt(i) - 'a']++;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return n - maxLength;
    }

    /**
     * TC: O(3) ~ O(1)
     * SC: O(1)
     */
    private boolean isCharsValid(int[] chars, int k) {
        for (int i = 0; i < 3; i++) {
            if (chars[i] < k) {
                return false;
            }
        }
        return true;
    }
}
