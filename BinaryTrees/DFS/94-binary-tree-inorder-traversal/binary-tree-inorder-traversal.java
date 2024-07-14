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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<Integer>();
        dfsTree(root, path);
        return path;
    }

    private void dfsTree(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }
        dfsTree(node.left, path);
        path.add(node.val);
        dfsTree(node.right, path);
    }
}
