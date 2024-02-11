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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> path = new ArrayList<Integer>();
        inorderPath(root, path);
        return path;
    }

    /**
     * Inorder - Left Node Right (LNR)
     */
    private void inorderPath(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }
        inorderPath(node.left, path);
        path.add(node.val);
        inorderPath(node.right, path);
    }
}