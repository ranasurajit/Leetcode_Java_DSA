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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (isLeafNode(root)) {
            return root.val == targetSum;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, targetSum));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int sum = current.sum - node.val;
            /* propagating the sum from root towards leafs and subtracting so that sum is zero at leaf 
             * (node.left == node .right == null)
             */
            if (sum == 0 && isLeafNode(node)) {
                return true;
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, sum));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, sum));
            }
        }
        return false;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    class Pair {
        TreeNode node;
        int sum;

        public Pair (TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}
