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
    public int maxPathSum(TreeNode root) {
        int[] max = { Integer.MIN_VALUE };
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, helper(node.left, max));
        int rightSum = Math.max(0, helper(node.right, max));
        max[0] = Math.max(max[0], leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}