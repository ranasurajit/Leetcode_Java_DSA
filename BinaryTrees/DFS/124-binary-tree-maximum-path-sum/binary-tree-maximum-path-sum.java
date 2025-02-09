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
     * Using DFS approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maxPathSum(TreeNode root) {
        int[] maxSum = { Integer.MIN_VALUE };
        solve(root, maxSum);
        return maxSum[0];
    }

    private int solve(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = solve(root.left, maxSum);
        int rightSum = solve(root.right, maxSum);
        /**
         * we may get a convergent path that turns up and down so we 
         * won't be sending it back to recursion
         * dono left and right acche
         */
        int option1 = root.val + leftSum + rightSum;
        /**
         * we may get either leftSum or rightSum to be better
         * so we may take the max(leftSum, rightSum) and return it
         * to the recursion
         * koi ek accha
         */
        int option2 = root.val + Math.max(leftSum, rightSum);
        /**
         * we may get only rootSum better
         * so we may take it and return it
         * to the recursion
         * sirf root accha
         */
        int option3 = root.val;
        maxSum[0] = Math.max(maxSum[0], Math.max(option1, Math.max(option2, option3)));
        return Math.max(option2, option3);
    }
}
