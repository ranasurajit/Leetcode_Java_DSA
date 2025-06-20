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
     * Approach : Using BFS Traversal Approach
     *
     * Intuition : We will mark each nodes with an index
     * leftIndex = parentIndex * 2 + 1
     * rightIndex = parentIndex * 2 + 2
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<Pair>(); // SC: O(N)
        queue.offer(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index;
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(maxIndex, index);
                maxWidth = Math.max(maxWidth, maxIndex - minIndex + 1);
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2));
                }
            }
        }
        return maxWidth;
    }

    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
