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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        dfsTree(root, "", list);
        return list;
    }

    private void dfsTree(TreeNode node, String current, List<String> list) {
        if (node == null) {
            return;
        }
        current = current == "" ? "" + node.val : current + "->" + node.val;
        if (node.left == null && node.right == null) {
            list.add(current);
            return;
        }
        dfsTree(node.left, current, list);
        dfsTree(node.right, current, list);
    }
}
