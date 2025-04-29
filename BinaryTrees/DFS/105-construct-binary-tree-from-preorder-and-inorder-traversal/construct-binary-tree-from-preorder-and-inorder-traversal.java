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
     * Approach : Using DFS Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            indexMap.put(inorder[i], i);
        }
        int[] preIdx = { 0 };
        return solve(preorder, inorder, indexMap, 0, n - 1, preIdx);
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solve(int[] preorder, int[] inorder, Map<Integer, Integer> indexMap, 
        int inStart, int inEnd, int[] preIdx) {
        // Base Case
        if (inStart > inEnd || preIdx[0] >= preorder.length) {
            return null;
        }
        // Recursion Calls
        int rootValue = preorder[preIdx[0]];
        TreeNode root = new TreeNode(rootValue);
        int rootIdx = indexMap.get(rootValue);
        preIdx[0]++;
        root.left = solve(preorder, inorder, indexMap, inStart, rootIdx - 1, preIdx);
        root.right = solve(preorder, inorder, indexMap, rootIdx + 1, inEnd, preIdx);
        return root;
    }
}
