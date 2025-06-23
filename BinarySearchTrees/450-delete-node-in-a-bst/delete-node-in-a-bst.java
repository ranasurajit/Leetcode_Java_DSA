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
     * Approach : Using Recursion + BST Property Approach
     * 
     * TC: O(H)
     * SC: O(H)
     * 
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // look-up to the left of root node
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // look-up to the right of root node
            root.right = deleteNode(root.right, key);
        } else {
            // we found the key match with root.val
            if (root.left == null) {
                // we need to hook the not null node to the parent of target node
                return root.right;
            } else if (root.right == null) {
                // we need to hook the not null node to the parent of target node
                return root.left;
            } else {
                /**
                 * target node has both left and right children, 
                 * so we can attach Max(left sub-tree) or Min(right sub-tree)
                 */
                // we need to now set the target node value to minValue
                root.val = getMinValue(root.right); // TC: O(H), SC: O(1)
                // we need to delete the minValue node from root's right
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    /**
     * Using Tree Traversal Approach with Pointers
     *
     * TC: O(H)
     * SC: O(1)
     */
    private int getMinValue(TreeNode root) {
        int minValue = root.val;
        TreeNode current = root;
        while (current.left != null) {
            minValue = current.left.val;
            current = current.left;
        }
        return minValue;
    }
}
