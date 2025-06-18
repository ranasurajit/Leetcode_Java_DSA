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
     * Approach : Using BFS Traversal Approach (Optimal Approach)
     *
     * TC: O(N)
     * SC: O(N)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        if (root == null) {
            return path;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            Deque<Integer> temp = new ArrayDeque<Integer>();
            for (int i = 0; i < size; i++) { // TC: O(K)
                TreeNode current = queue.poll();
                if ((level & 1) == 0) {
                    // even levels
                    temp.addLast(current.val);
                } else {
                    // odd levels
                    temp.addFirst(current.val); // TC: O(K), where K = size
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            path.add(new ArrayList<Integer>(temp));
            level++;
        }
        return path;
    }

    /**
     * Approach : Using BFS Traversal Approach
     *
     * TC: O(N + K ^ 2)
     * SC: O(N)
     */
    public List<List<Integer>> zigzagLevelOrderBFSArrayList(TreeNode root) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        if (root == null) {
            return path;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) { // TC: O(K)
                TreeNode current = queue.poll();
                if ((level & 1) == 0) {
                    // even levels
                    temp.add(current.val);
                } else {
                    // odd levels
                    temp.add(0, current.val); // TC: O(K), where K = size
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            path.add(temp);
            level++;
        }
        return path;
    }
}
