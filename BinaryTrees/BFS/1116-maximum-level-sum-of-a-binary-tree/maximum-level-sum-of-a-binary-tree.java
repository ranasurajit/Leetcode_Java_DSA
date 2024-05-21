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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // initial level at root = 1
        int currentLevel = 1;
        int maxSumLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentSum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumLevel = currentLevel;
            }
            // Increase level for next queue elements / level
            currentLevel++;
        }
        return maxSumLevel;
    }
}
