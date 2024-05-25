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
    // BFS Solution
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int level = current.level;
            depth = Math.max(depth, level);
            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }
        return depth + 1;
    }

    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
