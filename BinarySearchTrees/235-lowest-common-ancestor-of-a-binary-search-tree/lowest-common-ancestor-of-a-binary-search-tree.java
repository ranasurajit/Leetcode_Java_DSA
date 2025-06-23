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
     * Approach II : Using Recursion + BST Property Approach
     * 
     * TC: O(H)
     * SC: O(H)
     * 
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        if (current.val < p.val && current.val < q.val) {
            // both nodes 'p' and 'q' lie on the right side of 'current' node
            return lowestCommonAncestor(root.right, p, q);
        } else if (current.val > p.val && current.val > q.val) {
            // both nodes 'p' and 'q' lie on the left side of 'current' node
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N)
     * SC: O(H)
     * 
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null || root == p || root == q) {
            return root;
        }
        // Recursion Calls
        // Hypothesis
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Induction
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
