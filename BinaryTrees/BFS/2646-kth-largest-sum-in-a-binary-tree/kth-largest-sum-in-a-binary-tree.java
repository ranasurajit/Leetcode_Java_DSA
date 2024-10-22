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
     * TC: O(N + N x log(K) + (N - K) x log(K)) ~ O(N x log(K))
     * SC: O(N + K)
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1L;
        }
        PriorityQueue<Long> pq = new PriorityQueue<Long>(); // SC: O(K)
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // TC: O(log(K))
            if (pq.size() < k) {
                pq.offer(sum);
            } else if (sum > pq.peek()) {
                pq.poll();
                pq.offer(sum);
            }
        }
        if (pq.size() < k) {
            return -1L;
        }
        return pq.peek();
    }
}
