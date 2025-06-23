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
     * TC: O(N x log(N) + 2 x N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = preorder.clone(); // SC: O(N)
        Arrays.sort(inorder); // TC: O(N x log(N))
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            inorderMap.put(inorder[i], i);
        }
        int[] index = { 0 };
        return solveRecursion(index, 0, n - 1, preorder, inorderMap); // TC: O(N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solveRecursion(int[] index, int start, int end, int[] preorder,
        Map<Integer, Integer> inorderMap) {
        // Base Case
        if (index[0] == preorder.length) {
            return null;
        }
        if (start > end) {
            return null;
        }
        // Recursion Calls
        TreeNode root = new TreeNode(preorder[index[0]]);
        int idx = inorderMap.get(preorder[index[0]]);
        index[0]++;
        root.left = solveRecursion(index, start, idx - 1, preorder, inorderMap);
        root.right = solveRecursion(index, idx + 1, end, preorder, inorderMap);
        return root;
    }
}
