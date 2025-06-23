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
     * Approach II : Using DFS Inorder Traversal K depth Approach (Without Space)
     *
     * TC: O(K)
     * SC: O(K)
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] count = { 0 };
        int[] result = { -1 };
        dfsInorderBSTOptimal(root, k, count, result); // TC: O(K), SC: O(K)
        return result[0];
    }

    /**
     * Using DFS Inorder Traversal Based on K depth Approach
     *
     * TC: O(K)
     * SC: O(K)
     */
    private void dfsInorderBSTOptimal(TreeNode root, int k, int[] count, int[] result) {
        // Base Case
        if (root == null) {
            return;
        }
        dfsInorderBSTOptimal(root.left, k, count, result);
        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }
        dfsInorderBSTOptimal(root.right, k, count, result);
    }

    /**
     * Approach I : Using DFS Inorder Traversal Based on K depth Approach (With Space)
     *
     * TC: O(K)
     * SC: O(2 x K) ~ O(K)
     */
    public int kthSmallestUsingArrayList(TreeNode root, int k) {
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
