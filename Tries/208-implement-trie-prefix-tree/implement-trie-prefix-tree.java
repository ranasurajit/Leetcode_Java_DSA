/**
 * TC: O(N)
 * SC: O(N)
 */
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
        int i;
        for (i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return i == prefix.length();
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
