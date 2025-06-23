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
     * Approach : Using DFS Inorder Traversal Based on K depth Approach
     *
     * TC: O(K)
     * SC: O(2 x K) ~ O(K)
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<Integer>(); // SC: O(K)
        dfsInorderBST(root, k, result);
        return result.get(k - 1);
    }

    /**
     * Using DFS Inorder Traversal Based on K depth Approach
     *
     * TC: O(K)
     * SC: O(K)
     */
    private void dfsInorderBST(TreeNode root, int k, List<Integer> result) {
        // Base Case
        if (root == null) {
            return;
        }
        if (result.size() == k) {
            return;
        }
        dfsInorderBST(root.left, k, result);
        result.add(root.val);
        dfsInorderBST(root.right, k, result);
    }
}
