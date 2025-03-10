class Solution {
    /**
     * Approach: Using Sliding Window Technique (Variable Size) and Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        // pre-compute the indices where consonents is found after an index i
        int[] nextConsonentIndices = new int[n]; // SC: O(N)
        int nextIndex = n;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            nextConsonentIndices[i] = nextIndex;
            if (!isVowel(word.charAt(i))) {
                nextIndex = i;
            }
        }
        // Using sliding window technique (variable size)
        int consonents = 0;
        long count = 0L;
        int i = 0; // start pointer of sliding window
        int j = 0; // start pointer of sliding window
        Map<Character, Integer> vowelMap =
            new HashMap<Character, Integer>(); // SC: O(5)
        while (j < n) { // TC: O(N)
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
            } else {
                consonents++;
            }
            // when conditions are over met then shrink the window
            while (consonents > k) {
                char ci = word.charAt(i);
                if (isVowel(ci)) {
                    int freq = vowelMap.get(ci);
                    if (freq == 1) {
                        vowelMap.remove(ci);
                    } else {
                        vowelMap.put(ci, vowelMap.get(ci) - 1);
                    }
                } else {
                    consonents--;
                }
                i++;
            }
            // when conditions are just met then store the count and shrink the window
            while (i < n && vowelMap.size() == 5 && consonents == k) {
                int idx = nextConsonentIndices[j];
                count += idx - j;
                char ci = word.charAt(i);
                if (isVowel(ci)) {
                    int freq = vowelMap.get(ci);
                    if (freq == 1) {
                        vowelMap.remove(ci);
                    } else {
                        vowelMap.put(ci, vowelMap.get(ci) - 1);
                    }
                } else {
                    consonents--;
                }
                i++;
            }
            j++;
        }
        return count;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
