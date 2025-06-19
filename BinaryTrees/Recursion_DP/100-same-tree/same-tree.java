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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case
        if (p == null || q == null) {
            return p == q;
        }
        // Recursion Calls
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
