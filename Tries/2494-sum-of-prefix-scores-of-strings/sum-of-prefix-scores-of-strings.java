class Solution {
    TrieNode root = new TrieNode();

    /**
     * TC: O(K x N) where K = Maximum length of word in words array
     * SC: O(K x N)
     */
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        // insert
        for (String word : words) {
            insertWord(word);
        }
        // search each prefixes
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = getScore(words[i]);
        }
        return scores;
    }

    private int getScore(String word) {
        int score = 0;
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            score += crawler.children[index].countPrefix;
            crawler = crawler.children[index];
        }
        return score;
    }

    private void insertWord(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            // insert each character to Trie
            int index = ch - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler.children[index].countPrefix++;
            crawler = crawler.children[index];
        }
    }
}

class TrieNode {
    TrieNode[] children;
    int countPrefix;

    public TrieNode () {
        this.children = new TrieNode[26]; // to store all lowercase letters
        this.countPrefix = 0;
    }
}
