class Solution {
    /**
     * Using Trie - Optimal Approach
     *
     * TC: O(N x L + K)
     * SC: O(1)
     * where
     * N is the number of words in array 'words'
     * K is the length of 'prefix'
     * L is the average length of words in array 'words'
     */
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {      // TC: O(N)
            trie.insert(word);           // TC: O(L), SC: O(L)
        }
        return trie.countPrefixes(pref); // TC: O(K)
    }

    class Trie {

        TrieNode root;

        class TrieNode {
            boolean isEndOfWord;
            TrieNode[] children;
            int count;

            public TrieNode() {
                this.isEndOfWord = false;
                children = new TrieNode[26];
                count = 0;
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        private TrieNode createNode() {
            return new TrieNode();
        }

        /**
         * TC: O(L) where L is the average length of words
         * SC: O(L x 26) ~ O(L)
         */
        public void insert(String word) {
            TrieNode crawler = root;
            int n = word.length();
            for (int i = 0; i < n; i++) { // TC: O(N)
                int idx = word.charAt(i) - 'a';
                if (crawler.children[idx] == null) {
                    crawler.children[idx] = createNode();
                }
                crawler.count++;
                crawler = crawler.children[idx];
            }
            crawler.isEndOfWord = true;
            crawler.count++;
        }

        /**
         * TC: O(K) where K is the length of prefix
         * SC: O(1)
         */
        public int countPrefixes(String prefix) {
            TrieNode crawler = root;
            int n = prefix.length();
            int count = 0;
            for (int i = 0; i < n; i++) { // TC: O(N)
                int idx = prefix.charAt(i) - 'a';
                if (crawler.children[idx] == null) {
                    return 0;
                }
                crawler = crawler.children[idx];
                count = crawler.count;
            }
            return count;
        }
    }

    /**
     * Using String operation - Brute-Force Approach
     *
     * TC: O(K x N), where K = length of String 'pref'
     * SC: O(1)
     */
    public int prefixCountBruteForce(String[] words, String pref) {
        int n = pref.length();
        int count = 0;
        for (String word : words) {                  // TC: O(N)
            if (word.length() >= n && 
                word.startsWith(pref)) { // TC: O(K)
                count++;
            }
        }
        return count;
    }
}
