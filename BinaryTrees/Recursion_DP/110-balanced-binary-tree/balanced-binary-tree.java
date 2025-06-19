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
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isBalanced(TreeNode root) {
        if (dfsTreeRecursion(root) == -1) {
            return false;
        }
        return true;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int dfsTreeRecursion(TreeNode node) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Hypothesis - Recursion Leap of Faith
        int leftHeight = dfsTreeRecursion(node.left);
        int rightHeight = dfsTreeRecursion(node.right);
        // Induction
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        // passing the best result to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
