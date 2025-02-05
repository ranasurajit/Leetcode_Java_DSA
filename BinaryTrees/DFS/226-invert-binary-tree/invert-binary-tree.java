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
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // swap left and right children nodes for current node
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        // perform DFS operation on left and right sub-trees
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
