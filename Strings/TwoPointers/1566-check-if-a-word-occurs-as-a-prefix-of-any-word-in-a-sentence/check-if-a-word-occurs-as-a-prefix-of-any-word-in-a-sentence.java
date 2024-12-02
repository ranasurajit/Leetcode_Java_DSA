class Solution {
    /**
     * TC: O(W + N)
     * SC: O(1)
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) { // TC: O(W)
            if (isPresent(words[i], searchWord)) { // TC: O(N)
                return i + 1;
            }
        }
        return -1;
    }

    private boolean isPresent(String word, String searchWord) {
        if (word.length() < searchWord.length()) {
            return false;
        }
        return word.startsWith(searchWord);
    }
}
