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
     * Using DFS Traversal Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(postorder[i], i);
        }
        return solve(0, 0, n - 1, preorder, postorder, map); // TC: O(N), SC: O(N)
    }

    /**
     * Using DFS Traversal Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solve(int preSI, int postSI, int preEI, int[] preorder,
        int[] postorder, Map<Integer, Integer> map) {
        // Base case
        if (preSI > preEI) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSI]);
        if (preSI == preEI) {
            return root;
        }
        int nextNode = preorder[preSI + 1];
        int poFind = map.get(nextNode);
        int numElements = poFind - postSI + 1;
        // calling left sub-tree
        root.left = solve(preSI + 1, postSI, preSI + numElements,
            preorder, postorder, map);
        // calling right sub-tree
        root.right = solve(preSI + numElements + 1, poFind + 1, preEI,
            preorder, postorder, map);
        return root;
    }
}
