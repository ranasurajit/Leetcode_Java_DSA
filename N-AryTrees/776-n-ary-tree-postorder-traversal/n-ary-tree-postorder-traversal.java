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
    public List<Integer> postorder(Node root) {
        List<Integer> traversal = new ArrayList<Integer>();
        dfsTree(root, traversal);
        return traversal;
    }

    private void dfsTree(Node root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            dfsTree(child, traversal);
        }
        traversal.add(root.val);
    }
}
