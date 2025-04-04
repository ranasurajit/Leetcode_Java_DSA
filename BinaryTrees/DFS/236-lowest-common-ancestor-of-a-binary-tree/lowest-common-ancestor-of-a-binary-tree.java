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
     * Approach : Using DFS Approach
     *
     * TC: O(N) as all nodes visited twice
     * SC: O(N) - recursion stack space
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // DFS
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);
        if (leftChild != null && rightChild != null) {
            return root;
        }
        return leftChild == null ? rightChild : leftChild;
    }
}
