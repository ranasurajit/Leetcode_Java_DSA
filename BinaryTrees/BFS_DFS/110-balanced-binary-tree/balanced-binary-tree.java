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
     * Approach : Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (dfsTreeHeight(root) == -1) { // TC: O(N), SC: O(N)
            return false;
        }
        return true;
    }

    /**
     * Using DFS Approach to find Depth/Height from a Node
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int dfsTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsTreeHeight(root.left);
        int rightHeight = dfsTreeHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
