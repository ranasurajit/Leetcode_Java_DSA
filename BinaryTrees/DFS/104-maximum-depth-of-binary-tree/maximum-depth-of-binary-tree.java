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
        return dfsTree(root, 0);
    }

    private int dfsTree(TreeNode node, int level) {
        if (node == null) {
            return 0;
        }
        int left = dfsTree(node.left, level + 1);
        int right = dfsTree(node.right, level + 1);
        return 1 + Math.max(left, right);
    }
}
