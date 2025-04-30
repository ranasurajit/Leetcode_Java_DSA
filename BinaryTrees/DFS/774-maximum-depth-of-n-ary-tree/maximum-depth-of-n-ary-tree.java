/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC: O(N), we will visit all nodes
     * SC: O(H) ~ O(N) in case of skewed Tree
     */
    public int maxDepth(Node root) {
        // Base Case
        if (root == null) {
            return 0;
        }
        // Recursion Calls
        int maxHeight = 0;
        for (Node child : root.children) {
            int nodeHeight = maxDepth(child);
            maxHeight = Math.max(maxHeight, nodeHeight);
        }
        return 1 + maxHeight;
    }
}
