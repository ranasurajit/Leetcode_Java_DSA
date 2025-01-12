class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        TrieNode root = getNode(0);
        for (int i = 0; i < n; i++) {
            if (wordsContainer[root.idx].length() > wordsContainer[i].length()) {
                root.idx = i;
            }
            insert(root, wordsContainer, i);
        }
        int q = wordsQuery.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            result[i] = search(root, wordsQuery[i]);
        }
        return result;
    }

    class TrieNode {
        int idx;
        TrieNode[] children;

        public TrieNode() {
            idx = -1;
            children = new TrieNode[26];
        }
    }

    public TrieNode getNode(int idx) {
        TrieNode node = new TrieNode();
        node.idx = idx;
        for (int i = 0; i < 26; i++) {
            node.children[i] = null;
        }
        return node;
    }

    public void insert(TrieNode crawler, String[] wordsContainer, int idx) {
        String word = wordsContainer[idx];
        int n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            int chIdx = word.charAt(i) - 'a';
            if (crawler.children[chIdx] == null) {
                crawler.children[chIdx] = getNode(idx);
            }
            crawler = crawler.children[chIdx];
            if (wordsContainer[crawler.idx].length() > n) {
                crawler.idx = idx;
            }
        }
    }

    public void insertTrie(TrieNode pCrawl, String[] wordsContainer, int i) {
        String word = wordsContainer[i];
        int n = word.length();

        for (int j = n - 1; j >= 0; j--) {
            int ch_idx = word.charAt(j) - 'a';

            if (pCrawl.children[ch_idx] == null) {
                pCrawl.children[ch_idx] = getNode(i);
            }
            pCrawl = pCrawl.children[ch_idx];

            if (wordsContainer[pCrawl.idx].length() > n) {
                pCrawl.idx = i;
            }
        }
    }

    public int search(TrieNode crawler, String suffixWord) {
        int resultIdx = crawler.idx;
        int n = suffixWord.length();
        for (int i = n - 1; i >= 0; i--) {
            int chIdx = suffixWord.charAt(i) - 'a';
            if (crawler.children[chIdx] == null) {
                return resultIdx;
            }
            crawler = crawler.children[chIdx];
            resultIdx = crawler.idx;
        }
        return resultIdx;
    }
}
