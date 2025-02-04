/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }
        // compute LCA node from left sub-tree
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // compute LCA node from right sub-tree
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return leftLCA == null ? rightLCA : leftLCA;
    }
}
