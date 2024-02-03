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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        String rootStr = getPreOrder(root);
        String subRootStr = getPreOrder(subRoot);
        return rootStr.contains(subRootStr);
    }

    private String getPreOrder(TreeNode node) {
        if (node == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val + "^");
        sb.append(getPreOrder(node.left) + "^");
        sb.append(getPreOrder(node.right) + "^");
        return sb.toString();
    }
}