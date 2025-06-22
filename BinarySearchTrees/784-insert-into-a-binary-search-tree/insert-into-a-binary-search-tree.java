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
     * Approach : Using Iteration + BST Property Approach
     *
     * TC: O(H)
     * SC: O(1)
     *
     * Where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed BST
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                // we need to lookup in the left of current node
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else if (val > current.val) {
                // we need to lookup in the right of current node
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
