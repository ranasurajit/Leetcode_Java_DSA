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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int qmin = queue.peek().level;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int current = queue.peek().level - qmin;
                if (i == 0) {
                    first = current;
                }
                if (i == size - 1) {
                    last = current;
                }
                TreeNode currentNode = queue.poll().node;
                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.left, current * 2 + 1));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.right, current * 2 + 2));
                }
                width = Math.max(width, (last - first) + 1);
            }
        }
        return width;
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