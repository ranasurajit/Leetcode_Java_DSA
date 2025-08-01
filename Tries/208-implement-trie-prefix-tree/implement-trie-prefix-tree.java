class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
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

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
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
