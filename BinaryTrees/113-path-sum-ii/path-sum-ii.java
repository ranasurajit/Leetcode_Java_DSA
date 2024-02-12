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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<Integer> current = new ArrayList<Integer>();
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        dfsTree(root, targetSum, current, paths);
        return paths;
    }

    private void dfsTree(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        current.add(root.val);
        if (isLeafNode(root) && targetSum == 0) {
            paths.add(new ArrayList<Integer>(current));
        } else {
            dfsTree(root.left, targetSum, current, paths);
            dfsTree(root.right, targetSum, current, paths);
        }
        // backtrack
        current.remove(current.size() - 1);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}