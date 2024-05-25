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
    // DFS Solution
    public int maxDepth(TreeNode root) {
        return dfsTree(root);
    }

    private int dfsTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfsTree(node.left);
        int right = dfsTree(node.right);
        return 1 + Math.max(left, right);
    }
}
