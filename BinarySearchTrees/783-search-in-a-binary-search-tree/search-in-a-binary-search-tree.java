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
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root, val);
    }

    private TreeNode helper(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        if (val < node.val) {
            node = helper(node.left, val);
        } else {
            node = helper(node.right, val);
        }
        return node;
    }
}
