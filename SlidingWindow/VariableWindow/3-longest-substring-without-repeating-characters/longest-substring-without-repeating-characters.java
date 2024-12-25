class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0; // pointer at the start of sliding window
        int j = 0; // pointer at the end of sliding window
        Map<Character, Integer> unique = new HashMap<Character, Integer>(); // SC: O(N)
        int maxLength = Integer.MIN_VALUE;
        while (j < n) { // TC: O(N)
            unique.put(s.charAt(j), unique.getOrDefault(s.charAt(j), 0) + 1);
            while (unique.size() != j - i + 1) {
                // remove the character frequency from index i
                unique.put(s.charAt(i), unique.getOrDefault(s.charAt(i), 0) - 1);
                if (unique.get(s.charAt(i)) == 0) {
                    // remove the key from Map if the frequency becomes zero after decreasing frequency
                    unique.remove(s.charAt(i));
                }
                i++;
            }
            if (unique.size() == j - i + 1) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
