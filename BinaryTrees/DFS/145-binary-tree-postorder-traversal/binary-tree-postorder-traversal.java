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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<Integer>();
        dfsTree(root, path);
        return path;
    }

    
    private void dfsTree(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        dfsTree(root.left, path);
        dfsTree(root.right, path);
        path.add(root.val);
    }
}
