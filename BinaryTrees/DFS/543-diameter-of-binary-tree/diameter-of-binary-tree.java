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
     * Approach : Using DFS Approach
     *
     * TC: O(N), we will visit all nodes
     * SC: O(H) ~ O(N) in case of skewed Tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = { 0 };
        solveHeight(root, diameter);
        return diameter[0];
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(H) ~ O(N) in case of skewed Tree
     */
    private int solveHeight(TreeNode root, int[] diameter) {
        // Base Case
        if (root == null) {
            return 0;
        }
        // Recursion Calls
        int leftHeight = solveHeight(root.left, diameter);
        int rightHeight = solveHeight(root.right, diameter);
        // diameter = left height + right height (at the node / turning point)
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
