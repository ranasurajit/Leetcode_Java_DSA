class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(2 x 26) ~ O(1)
     */
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int[] textChars = new int[26];    // SC: O(26)
        int[] balloonChars = new int[26]; // SC: O(26)
        String balloon = "balloon";
        for (char ch : balloon.toCharArray()) { // TC: O(8) ~ O(1)
            balloonChars[ch - 'a']++;
        }
        for (char ch : text.toCharArray()) { // TC: O(N)
            textChars[ch - 'a']++;
        }
        int count = n;
        boolean notFoundAll = false;
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            if (balloonChars[i] > 0 && textChars[i] > 0) {
                count = Math.min(count, textChars[i] / balloonChars[i]);
            } else if (balloonChars[i] > 0 && textChars[i] == 0) {
                notFoundAll = true;
                return 0;
            }
        }
        return count;
    }
}
