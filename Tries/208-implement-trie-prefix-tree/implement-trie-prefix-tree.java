class Trie {

    TrieNode root;

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }

    private TrieNode createNode() {
        return new TrieNode();
    }

    public Trie() {
        root = createNode();
    }
    
    /**
     * TC: O(N)
     * SC: O(N x 26) ~ O(N)
     */
    public void insert(String word) {
        TrieNode crawler = root;
        int n = word.length();
        for (int i = 0; i < n; i++) { // TC: O(N)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = createNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean search(String word) {
        TrieNode crawler = root;
        int n = word.length();
        int i = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return i == n && crawler.isEndOfWord;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int n = prefix.length();
        int i = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            int idx = prefix.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return i == n;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
