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
     * Approach : Using DFS Traversal Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null || root == p || root == q) {
            return root;
        }
        // Hypothesis
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        // Induction
        if (leftTree == null) {
            // not found in left sub-tree so possibly both are in right sub-tree
            return rightTree;
        }
        if (rightTree == null) {
            // not found in right sub-tree so possibly both are in left sub-tree
            return leftTree;
        }
        return root;
    }
}
