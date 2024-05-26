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
        StringBuilder sb = new StringBuilder();
        dfsTree(root, sb, list);
        return list;
    }

    private void dfsTree(TreeNode node, StringBuilder current, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            current.append(node.val);
            list.add(current.toString());
            return;
        }
        int size = current.length();
        dfsTree(node.left, current.append(node.val).append("->"), list);
        current.setLength(size);
        dfsTree(node.right, current.append(node.val).append("->"), list);
        current.setLength(size);
    }
}
