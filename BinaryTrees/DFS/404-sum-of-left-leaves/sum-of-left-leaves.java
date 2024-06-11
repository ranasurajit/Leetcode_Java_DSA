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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = {0};
        dfsTree(root, sum, false);
        return sum[0];
    }

    private void dfsTree(TreeNode node, int[] sum, boolean flag) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && flag) {
            sum[0] += node.val;
        }
        dfsTree(node.left, sum, true);
        dfsTree(node.right, sum, false);
    }
}
