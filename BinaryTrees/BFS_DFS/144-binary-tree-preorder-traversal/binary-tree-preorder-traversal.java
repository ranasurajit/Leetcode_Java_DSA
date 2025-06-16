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
    /**
     * Approach : Using Pre-order traversal (Node, Left, Right) Approach
     *
     * TC: O(N)
     * SC: O(H) where H = height of Binay Tree (H = log(N), but in worst case skewed tree H ~ N)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<Integer>();
        if (root == null) {
            return path;
        }
        dfsTree(root, path);
        return path;
    }

    /**
     * Using Pre-order traversal (Node, Left, Right) Approach
     *
     * TC: O(N)
     * SC: O(H) where H = height of Binay Tree (H = log(N), but in worst case skewed tree H ~ N)
     */
    private void dfsTree(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        dfsTree(root.left, path);
        dfsTree(root.right, path);
    }
}
