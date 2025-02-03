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
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // compute height from left sub-tree
        int lh = maxDepth(root.left);
        // compute height from right sub-tree
        int rh = maxDepth(root.right);
        // height = max of left or right height of sub-tree + root node
        return 1 + Math.max(lh, rh);
    }
}
