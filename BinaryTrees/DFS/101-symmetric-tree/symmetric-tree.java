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
     * Approach : Using Recursion + DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isSymmetric(TreeNode root) {
        // Base Case
        if (root == null) {
            return true;
        }
        return isTreeMirrored(root.left, root.right);
    }

    /**
     * Using Recursion + DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private boolean isTreeMirrored(TreeNode leftTree, TreeNode rightTree) {
        // Base Case
        if (leftTree == null) {
            return rightTree == null;
        }
        if (rightTree == null) {
            return leftTree == null;
        }
        // Recursion Calls
        return leftTree.val == rightTree.val &&
            isTreeMirrored(leftTree.left, rightTree.right) &&
            isTreeMirrored(leftTree.right, rightTree.left);
    }
}
