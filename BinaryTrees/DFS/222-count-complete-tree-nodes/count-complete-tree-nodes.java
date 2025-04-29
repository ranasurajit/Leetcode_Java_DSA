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
     * TC: O(N)
     * SC: O(H)
     * 
     * where H = log(N) in case of complete binary tree
     */
    public int countNodes(TreeNode root) {
        return dfsTree(root);
    }

    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(H)
     * 
     * where H = log(N) in case of complete binary tree
     */
    private int dfsTree(TreeNode root) {
        // Base Case
        if (root == null) {
            return 0;
        }
        // Recursion Calls
        int leftCount = dfsTree(root.left);
        int rightCount = dfsTree(root.right);
        return 1 + leftCount + rightCount;
    }
}
