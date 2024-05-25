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
    // DFS Solution
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        dfsTree(root1, q1);
        dfsTree(root2, q2);
        System.out.println(q1);
        System.out.println(q2);
        if (q1.size() != q2.size()) {
            return false;
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int node1 = q1.poll();
            int node2 = q2.poll();
            if (node1 != node2) {
                return false;
            }
        }
        return true;
    }

    private void dfsTree(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        // Leaf node condition
        if (node.left == null && node.right == null) {
            queue.offer(node.val);
        }
        dfsTree(node.left, queue);
        dfsTree(node.right, queue);
    }
}
