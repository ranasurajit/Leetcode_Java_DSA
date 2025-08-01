/**
 * Approach : Using Trie Approach
 * 
 * TC: O(L x N)
 * SC: O(L)
 *
 * where N = number of queries, L = Max(words) sent as parameter
 */
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Using Trie Approach
     * 
     * TC: O(L)
     * SC: O(L)
     *
     * where L = Max(words) sent as parameter
     */
    public void insert(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) { // TC: O(L)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEnd = true;
    }
    
    /**
     * Using Trie Approach
     * 
     * TC: O(L)
     * SC: O(1)
     *
     * where L = Max(words) sent as parameter
     */
    public boolean search(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) { // TC: O(L)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler.isEnd;
    }
    
    /**
     * Using Trie Approach
     * 
     * TC: O(L)
     * SC: O(1)
     *
     * where L = Max(words) sent as parameter
     */
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (int i = 0; i < prefix.length(); i++) { // TC: O(L)
            int idx = prefix.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return true;
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode () {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
