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
    public int minCameraCover(TreeNode root) {
        int[] cameras = { 0 };
        if (dfsTree(root, cameras) == 0) {
            cameras[0]++;
        }
        return cameras[0];
    }

    private int dfsTree(TreeNode node, int[] sum) {
        if (node == null) {
            return 1;
        }
        int left = dfsTree(node.left, sum);
        int right = dfsTree(node.right, sum);
        if (left == 0 || right == 0) {
            sum[0]++;
            return 2;
        } else if (left == 2 || right == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}