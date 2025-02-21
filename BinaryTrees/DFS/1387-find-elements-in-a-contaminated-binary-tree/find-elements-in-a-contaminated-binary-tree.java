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
    BitSet bitSet;

    /**
     * Using DFS Approach
     *
     * TC: O(N) - visiting all nodes exactly once
     * SC: O(N)
     */
    public FindElements(TreeNode root) {
        this.root = root;
        this.bitSet = new BitSet();
        recoverBinaryTree(root, 0, bitSet);
    }

    private void recoverBinaryTree(TreeNode root, int value, BitSet bitSet) {
        if (root == null) {
            return;
        }
        root.val = value;
        bitSet.set(value);
        if (root.left != null) {
            recoverBinaryTree(root.left, 2 * value + 1, bitSet);
        }
        if (root.right != null) {
            recoverBinaryTree(root.right, 2 * value + 2, bitSet);
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public boolean find(int target) {
        return bitSet.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
