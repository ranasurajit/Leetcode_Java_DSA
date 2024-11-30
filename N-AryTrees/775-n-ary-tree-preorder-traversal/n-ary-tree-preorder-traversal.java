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
     * TC: O(N)
     * SC: O(H), where H = height of N-Ary Tree - Recursive stack space
     */
    public List<Integer> preorder(Node root) {
        List<Integer> path = new ArrayList<Integer>();
        traverse(root, path);
        return path;
    }

    private void traverse(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        for (Node child : root.children) {
            traverse(child, path);
        }
    }
}
