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
     * Intuition: pre-order guarantees that root node is at the beginning
     * in-order guarantees the left and right sub-tree positions
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        // we will be storing inorder traversal array in HashMap to figure out index in O(1) complexity
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            inorderMap.put(inorder[i], i);
        }
        int[] index = { 0 };
        return solveRecursion(preorder, index, 0, n - 1, inorderMap); // TC: O(N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N) 
     */
    private TreeNode solveRecursion(int[] preorder, int[] index, int start, int end,
        Map<Integer, Integer> inorderMap) {
        // Base Case
        if (index[0] == preorder.length) {
            return null;
        }
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        int idx = inorderMap.get(preorder[index[0]]);
        index[0]++;
        // Pre Order - Node Left Right
        root.left = solveRecursion(preorder, index, start, idx - 1, inorderMap);
        root.right = solveRecursion(preorder, index, idx + 1, end, inorderMap);
        return root;
    }
}
