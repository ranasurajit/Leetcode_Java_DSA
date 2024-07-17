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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<TreeNode>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int it : to_delete) {
            hs.add(it);
        }
        deleteHelper(root, hs, forest);
        if (!hs.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode deleteHelper(TreeNode root, HashSet<Integer> hs, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }
        root.left = deleteHelper(root.left, hs, forest);
        root.right = deleteHelper(root.right, hs, forest);
        if (hs.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            return null;
        } else {
            return root;
        }
    }
}
