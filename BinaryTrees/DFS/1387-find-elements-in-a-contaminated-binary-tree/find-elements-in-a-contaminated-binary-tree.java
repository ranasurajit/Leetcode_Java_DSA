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
    HashSet<Integer> set;

    /**
     * Using DFS Approach
     *
     * TC: O(N) - visiting all nodes exactly once
     * SC: O(N)
     */
    public FindElements(TreeNode root) {
        this.root = root;
        this.set = new HashSet<Integer>();
        recoverBinaryTree(root, 0, set);
    }

    private void recoverBinaryTree(TreeNode root, int value, HashSet<Integer> set) {
        if (root == null) {
            return;
        }
        root.val = value;
        set.add(value);
        if (root.left != null) {
            recoverBinaryTree(root.left, 2 * value + 1, set);
        }
        if (root.right != null) {
            recoverBinaryTree(root.right, 2 * value + 2, set);
        }
    }
    
    /**
     * Using Hashing Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
