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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = { 0 };
        return createBST(preorder, Integer.MAX_VALUE, index);
    }

    private TreeNode createBST(int[] preorder, int max, int[] index) {
        // Base case
        if (index[0] == preorder.length || preorder[index[0]] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = createBST(preorder, root.val, index);
        root.right = createBST(preorder, max, index);
        return root;
    }
}