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
     * Single Pass Approach
     * TC: O(N)
     * SC: O(N)
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int levelSum = root.val;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            int nextLevelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                current.val = levelSum - current.val;
                int sibSum = (current.left != null ? current.left.val : 0) +
                             (current.right != null ? current.right.val : 0);
                if (current.left != null) {
                    nextLevelSum += current.left.val;
                    current.left.val = sibSum;
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    nextLevelSum += current.right.val;
                    current.right.val = sibSum;
                    queue.offer(current.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }

    /**
     * Two Pass Approach
     * TC: O(2N) ~ O(N)
     * SC: O(2N) ~ O(N)
     */
    public TreeNode replaceValueInTreeTwoPass(TreeNode root) {
        if (root == null) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            int sum = 0;
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
            hm.put(level++, sum);
        }
        queue = new LinkedList<TreeNode>();
        root.val = 0;
        queue.offer(root);
        level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                int sibSum = (current.left != null ? current.left.val : 0) + 
                             (current.right != null ? current.right.val : 0);
                if (current.left != null) {
                    current.left.val = hm.get(level + 1) - sibSum;
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    current.right.val = hm.get(level + 1) - sibSum;
                    queue.offer(current.right);
                }
            }
            level++;
        }
        return root;
    }
}
