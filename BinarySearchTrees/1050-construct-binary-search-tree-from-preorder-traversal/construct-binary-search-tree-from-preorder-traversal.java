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
     * Approach II : Using Recursion (Binary Search Tree Property) Approach
     *
     * Intuition: pre-order guarantees that root node is at the beginning
     * any value to the left of root should be < root.val (bound) and to 
     * the right should be < Integer.MAX_VALUE
     *
     * TC: O(N)
     * SC: O(H) ~ O(N)
     *
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = { 0 };
        return solveRecursionBST(index, preorder, Integer.MAX_VALUE);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(H)
     */
    private TreeNode solveRecursionBST(int[] index, int[] preorder, int bound) {
        // Base Case
        if (index[0] == preorder.length || preorder[index[0]] >= bound) {
            return null;
        }
        // Recursion Calls
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = solveRecursionBST(index, preorder, root.val);
        root.right = solveRecursionBST(index, preorder, bound);
        return root;
    }

    /**
     * Approach I : Using Recursion (Binary Tree) Approach
     *
     * Intuition: pre-order guarantees that root node is at the beginning
     * in-order guarantees the left and right sub-tree positions
     *
     * TC: O(N x log(N) + 2 x N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public TreeNode bstFromPreorderRecursionBT(int[] preorder) {
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
