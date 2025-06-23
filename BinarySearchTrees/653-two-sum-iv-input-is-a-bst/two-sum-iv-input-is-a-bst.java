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
     * Approach : Using DFS Traversal + Hashing + Recursion Approach
     *
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N)
        return solveRecursion(root, k, set);
    }

    /**
     * Using DFS Traversal + Hashing + Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private boolean solveRecursion(TreeNode root, int k, Set<Integer> set) {
        // Base Case
        if (root == null) {
            return false;
        }
        // Induction
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        // Hypothesis
        return solveRecursion(root.left, k, set) || solveRecursion(root.right, k, set);
    }

    /**
     * Approach I : Using Inorder Traversal (Left Root Right) + Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean findTargetBruteForce(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<Integer>(); // SC: O(N)
        dfsBSTTree(root, inorder); // TC: O(N), SC: O(N)
        // By property of BST, inorder of BST is always sorted, so applying Two Pointers Approach
        int p = 0;
        int q = inorder.size() - 1;
        while (p < q) { // TC: O(N)
            int sum = inorder.get(p) + inorder.get(q);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                p++;
            } else {
                q--;
            }
        }
        return false;
    }

    /**
     * Using Inorder Traversal (Left Root Right) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsBSTTree(TreeNode root, List<Integer> inorder) {
        // Base Case
        if (root == null) {
            return;
        }
        // Recursion Calls
        dfsBSTTree(root.left, inorder);
        inorder.add(root.val);
        dfsBSTTree(root.right, inorder);
    }
}
