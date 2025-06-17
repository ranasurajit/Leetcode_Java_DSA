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
        List<String> paths = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfsTree(root, sb, paths);
        return paths;
    }

    private void dfsTree(TreeNode root, StringBuilder sb, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            paths.add(sb.toString());
            return;
        }
        int size = sb.length();
        dfsTree(root.left, sb.append(root.val).append("->"), paths);
        sb.setLength(size);
        dfsTree(root.right, sb.append(root.val).append("->"), paths);
        sb.setLength(size);
    }
}
