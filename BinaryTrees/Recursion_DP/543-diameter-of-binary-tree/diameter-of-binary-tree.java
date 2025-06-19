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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = { 0 }; // need to pass it as pass by reference
        solveRecursion(root, diameter);
        return diameter[0];
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveRecursion(TreeNode node, int[] diameter) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Hypothesis - Recursion Calls will do the magic
        int leftHeight = solveRecursion(node.left, diameter);
        int rightHeight = solveRecursion(node.right, diameter);
        // if diameter passes through this node 'node'
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        // if diameter does not pass through this node 'node' then return the best answer to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
