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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            indexMap.put(inorder[i], i);
        }
        int[] postIdx = { postorder.length - 1 };
        return solve(inorder, postorder, indexMap, 0, n - 1, postIdx); // TC: O(N), SC: O(N)
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solve(int[] inorder, int[] postorder, Map<Integer, Integer> indexMap,
        int inStart, int inEnd, int[] postIdx) {
        // Base Case
        if (inStart > inEnd || postIdx[0] < 0) {
            return null;
        }
        // Recursion Calls - Left Right Node
        int rootValue = postorder[postIdx[0]];
        TreeNode root = new TreeNode(rootValue);
        int rootIdx = indexMap.get(rootValue);
        postIdx[0]--;
        root.right = solve(inorder, postorder, indexMap, rootIdx + 1, inEnd, postIdx);
        root.left = solve(inorder, postorder, indexMap, inStart, rootIdx - 1, postIdx);
        return root;
    }
}
