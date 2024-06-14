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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        dfsTree(root, view, 0);
        return view;
    }

    private void dfsTree(TreeNode node, List<Integer> view, int level) {
        if (node == null) {
            return;
        }
        if (level == view.size()) {
            view.add(node.val);
        }
        dfsTree(node.right, view, level + 1);
        dfsTree(node.left, view, level + 1);
    }
}
