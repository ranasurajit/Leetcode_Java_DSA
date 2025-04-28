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
        int m = preorder.length;
        int n = inorder.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            indexMap.put(inorder[i], i);
        }
        return solve(preorder, inorder, indexMap, 0, m - 1, 0, n - 1);
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solve(int[] preorder, int[] inorder, Map<Integer, Integer> indexMap,
        int psIndex, int peIndex, int isIndex, int ieIndex) {
        // Base Case
        if (psIndex > peIndex || isIndex > ieIndex) {
            return null;
        }
        // Recursion Calls
        int rootValue = preorder[psIndex];
        int rootIdx = indexMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftSize = rootIdx - isIndex;
        int rightSize = ieIndex - rootIdx;
        root.left = solve(preorder, inorder, indexMap, 
            psIndex + 1, psIndex + leftSize, isIndex, rootIdx - 1);
        root.right = solve(preorder, inorder, indexMap, 
            psIndex + leftSize + 1, psIndex + leftSize + rightSize, rootIdx + 1, ieIndex);
        return root;
    }
}
