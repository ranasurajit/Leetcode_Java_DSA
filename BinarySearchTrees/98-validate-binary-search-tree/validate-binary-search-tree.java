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
     * Approach : Using Recursion + BST Property Approach
     * 
     * TC: O(N)
     * SC: O(H)
     * 
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Using Recursion + BST Property Approach
     * 
     * TC: O(N)
     * SC: O(H)
     */
    private boolean isBST(TreeNode root, long start, long end) {
        // Base Case
        if (root == null) {
            return true;
        }
        // Range Check for BST Property
        if (root.val <= start || root.val >= end) {
            return false;
        }
        // Recursion
        return isBST(root.left, start, root.val) && isBST(root.right, root.val, end);
    }
}
