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
     * Approach I : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maxPathSum(TreeNode root) {
        int[] maxSum = { Integer.MIN_VALUE };
        solveRecursion(root, maxSum);
        return maxSum[0];
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveRecursion(TreeNode node, int[] maxSum) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Hypothesis - Recursion Leap of Faith
        int leftSum = solveRecursion(node.left, maxSum);
        int rightSum = solveRecursion(node.right, maxSum);
        // Induction
        // compute maxSum assuming if it passed through node else pass the best value to its parent
        if (leftSum < 0) {
            leftSum = 0;
        }
        if (rightSum < 0) {
            rightSum = 0;
        }
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);
        // return the best value to its parent
        return node.val + Math.max(0, Math.max(leftSum, rightSum));
    }
}
