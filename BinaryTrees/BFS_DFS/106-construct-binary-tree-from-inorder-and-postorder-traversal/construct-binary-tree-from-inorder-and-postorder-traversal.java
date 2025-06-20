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
     * Approach : Using Recursion Approach
     *
     * Intuition: post-order guarantees that root node is at the end
     * in-order guarantees the left and right sub-tree positions
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // we will be storing inorder traversal array in HashMap to figure out index in
        // O(1) complexity
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            inorderMap.put(inorder[i], i);
        }
        int[] index = { n - 1 };
        return solveRecursion(postorder, index, 0, n - 1, inorderMap); // TC: O(N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solveRecursion(int[] postorder, int[] index, int start, int end, 
        Map<Integer, Integer> inorderMap) {
        // Base Case
        if (start > end) {
            return null;
        }
        if (index[0] < 0) {
            return null;
        }
        // Recursion Calls
        TreeNode root = new TreeNode(postorder[index[0]]);
        int idx = inorderMap.get(postorder[index[0]]);
        // Post Order - Left Right Node
        index[0]--;
        root.right = solveRecursion(postorder, index, idx + 1, end, inorderMap);
        root.left = solveRecursion(postorder, index, start, idx - 1, inorderMap);
        return root;
    }
}
