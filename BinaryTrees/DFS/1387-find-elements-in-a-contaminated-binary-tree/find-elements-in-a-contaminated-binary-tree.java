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
/**
 * Using DFS Approach
 *
 * TC: O(N) - visiting all nodes exactly once
 * SC: O(N)
 */
class FindElements {

    TreeNode root = null;

    /**
     * Using DFS Approach
     *
     * TC: O(N) - visiting all nodes exactly once
     * SC: O(N)
     */
    public FindElements(TreeNode root) {
        this.root = root;
        recoverBinaryTree(root, 0);
    }

    private void recoverBinaryTree(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        root.val = value;
        if (root.left != null) {
            recoverBinaryTree(root.left, 2 * value + 1);
        }
        if (root.right != null) {
            recoverBinaryTree(root.right, 2 * value + 2);
        }
    }
    
    /**
     * Using DFS Approach
     *
     * TC: O(N) - visiting all nodes exactly once
     * SC: O(N)
     */
    public boolean find(int target) {
        return findSolve(root, target);
    }

    private boolean findSolve(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return findSolve(root.left, target) || findSolve(root.right, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
