class Trie {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode () {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode crawl = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = new TrieNode();
            }
            crawl = crawl.children[idx];
        }
        crawl.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode crawl = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawl.children[idx] == null) {
                return false;
            }
            crawl = crawl.children[idx];
        }
        return crawl.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (crawl.children[idx] == null) {
                return false;
            }
            crawl = crawl.children[idx];
        }
        return crawl != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */