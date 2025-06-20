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
     * Approach : Using DFS Traversal + Recursion Approach
     * 
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        dfsTree(root, sb, paths);
        return paths;
    }

    /**
     * Using DFS Traversal + Recursion Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsTree(TreeNode node, StringBuilder sb, List<String> paths) {
        // Base Case
        if (node == null) {
            return;
        }
        // Recursion Calls
        int size = sb.length();
        sb.append(node.val).append("->"); // modify
        if (node.left == null && node.right == null) {
            // leaf node
            // Induction
            sb.setLength(sb.length() - 2); // removing extra '->'
            paths.add(sb.toString());
        } else {
            // Hypothesis
            dfsTree(node.left, sb, paths);  // explore
            dfsTree(node.right, sb, paths); // explore
        }
        sb.setLength(size); // backtrack
    }
}
