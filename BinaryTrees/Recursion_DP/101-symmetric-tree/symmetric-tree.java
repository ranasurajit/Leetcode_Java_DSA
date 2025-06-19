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
    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root.left, root.right);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private boolean isMirrorTree(TreeNode leftTree, TreeNode rightTree) {
        // Base Case
        if (leftTree == null || rightTree == null) {
            return leftTree == rightTree;
        }
        // Recursion Calls
        return leftTree.val == rightTree.val &&
            isMirrorTree(leftTree.left, rightTree.right) &&
            isMirrorTree(leftTree.right, rightTree.left);
    }
}
