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
     * Approach II : Using Recursion + Memoization Approach
     *
     * (DP Not needed here as each node is visited once)
     * 
     * DP helps only if:
     * You're recomputing results for overlapping subproblems.
     * You're solving a top-down problem with heavy subtree reuse.
     *
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxPathSum(TreeNode root) {
        int[] maxSum = { Integer.MIN_VALUE };
        Map<TreeNode, Integer> memo = new HashMap<TreeNode, Integer>();
        solveMemoization(root, maxSum, memo);
        return maxSum[0];
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(TreeNode node, int[] maxSum, Map<TreeNode, Integer> memo) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Memoization Calls
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        // Hypothesis - Recursion Leap of Faith
        int leftSum = solveMemoization(node.left, maxSum, memo);
        int rightSum = solveMemoization(node.right, maxSum, memo);
        // Induction
        // compute maxSum assuming if it passed through node else pass the best value to its parent
        // check if leftSum or rightSum < 0 then do not contribute
        if (leftSum < 0) {
            leftSum = 0;
        }
        if (rightSum < 0) {
            rightSum = 0;
        }
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);
        // return the best value to its parent
        int currentSum = node.val + Math.max(0, Math.max(leftSum, rightSum));
        memo.put(node, currentSum);
        return currentSum;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maxPathSumRecursion(TreeNode root) {
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
        // check if leftSum or rightSum < 0 then do not contribute
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
