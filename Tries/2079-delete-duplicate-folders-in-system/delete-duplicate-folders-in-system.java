class Solution {
    private Map<String, List<TrieNode>> map = new HashMap<String, List<TrieNode>>();

    /**
     * Approach : Using Trie + DFS + Backtracking Approach
     *
     * TC: O(N x L x log(C))
     * SC: O(N * L)
     * 
     * where C = maximum number of children nodes
     */
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("/");
        for (List<String> path : paths) {
            insertIntoTrie(root, path);
        }
        dfsMarkingTree(root); // marking sorted strings to Map with key (a(b(x(y)))) ...
        for (List<TrieNode> group : map.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.remove = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        collectPaths(root, new ArrayList<String>(), result);
        return result;
    }

    private void collectPaths(TrieNode root, List<String> path, List<List<String>> result) {
        if (root.remove) {
            return;
        }
        if (!root.folder.equals("/")) {
            path.add(root.folder);
            result.add(new ArrayList<String>(path));
        }
        for (TrieNode child : root.children.values()) {
            collectPaths(child, path, result);
        }
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }
    }

    private String dfsMarkingTree(TrieNode root) {
        // Base Case
        if (root.children.isEmpty()) {
            return "";
        }
        List<String> list = new ArrayList<String>();
        for (TrieNode child : root.children.values()) {
            String str = dfsMarkingTree(child);
            list.add("(" + child.folder + str + ")");
        }
        Collections.sort(list);
        String structure = String.join("", list);
        if (!root.folder.equals("")) {
            map.computeIfAbsent(structure, k-> new ArrayList<TrieNode>()).add(root);
        }
        return structure;
    }

    private void insertIntoTrie(TrieNode root, List<String> path) {
        TrieNode crawler = root;
        for (String s : path) {
            if (!crawler.children.containsKey(s)) {
                crawler.children.putIfAbsent(s, new TrieNode(s));
            }
            crawler = crawler.children.get(s);
        }
    }

    class TrieNode {
        String folder;
        boolean remove;
        Map<String, TrieNode> children;

        public TrieNode(String folder) {
            this.folder = folder;
            this.remove = false;
            this.children = new HashMap<String, TrieNode>();
        }
    }
}
