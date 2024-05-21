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
    // DFS Solution
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        dfsTree(root, 0, view);
        return view;
    }

    private void dfsTree(TreeNode node, int level, List<Integer> view) {
        if (node == null) {
            return;
        }
        if (view.size() == level) {
            view.add(node.val);
        }
        dfsTree(node.right, level + 1, view);
        dfsTree(node.left, level + 1, view);
    }
}
