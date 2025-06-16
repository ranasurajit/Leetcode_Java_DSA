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
     * TC: O(N)
     * SC: O(N)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        if (root == null) {
            return path;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            path.add(level);
        }
        return path;
    }
}
