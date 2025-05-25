class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();           // SC: O(N)
        Map<String, Integer> palindromeMap = new HashMap<String, Integer>(); // SC: O(N)
        int length = 0;
        for (String word : words) {                 // TC: O(N)
            if (word.charAt(0) == word.charAt(1)) {
                palindromeMap.put(word, palindromeMap.getOrDefault(word, 0) + 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String key : map.keySet()) {           // TC: O(N)
            int freq = map.get(key);
            int revFreq = 0;
            String revKey = key.charAt(1) + "" + key.charAt(0);
            if (map.containsKey(revKey)) {
                revFreq = map.get(revKey);
            }
            length += Math.min(freq, revFreq);
        }
        length = length * 2; // each string contributes 2 length
        int palindromeLength = 0;
        boolean hasOddPalindrome = false;
        for (String key : palindromeMap.keySet()) { // TC: O(N)
            // we can consider only one palindromic string which has the maximum length
            int freq = palindromeMap.get(key);
            if ((freq & 1) == 0) {
                // even frequencies
                palindromeLength += freq;
            } else {
                palindromeLength += freq - 1;
                hasOddPalindrome = true;
            }
        }
        if (hasOddPalindrome) {
            palindromeLength += 1;
        }
        palindromeLength = palindromeLength * 2; // palindromic string contributes 2 length
        return length + palindromeLength;
    }
}
