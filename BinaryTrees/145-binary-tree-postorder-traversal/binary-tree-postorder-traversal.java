/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        if (root == null) {
            return traversal;
        }
        dfsTree(root, traversal);
        return traversal;
    }

    private void dfsTree(TreeNode node, List<Integer> traversal) {
        if (node == null) {
            return;
        }
        dfsTree(node.left, traversal);
        dfsTree(node.right, traversal);
        traversal.add(node.val);
    }
}
