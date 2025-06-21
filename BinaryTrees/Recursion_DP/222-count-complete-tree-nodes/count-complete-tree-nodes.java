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
     * Approach : Using Recursion + DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int countNodes(TreeNode root) {
        return solveRecursion(root);
    }

    /**
     * Using Recursion + DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveRecursion(TreeNode root) {
        // Base Case
        if (root == null) {
            return 0;
        }
        // Hypothesis
        int leftCount = solveRecursion(root.left);
        int rightCount = solveRecursion(root.right);
        // Induction
        return 1 + leftCount + rightCount;
    }
}
