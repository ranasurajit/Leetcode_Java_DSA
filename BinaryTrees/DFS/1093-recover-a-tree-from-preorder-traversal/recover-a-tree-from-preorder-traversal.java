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
     * Using Pre-order DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     *
     * where N is the length of String 'traversal'
     */
    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length();
        int[] index = { 0 };
        int depth = 0;
        return solve(traversal, index, depth, n);
    }

    /**
     * Using Pre-order DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode solve(String s, int[] index, int depth, int n) {
        // Base case
        if (index[0] >= n) {
            // iteration exceeds length N of String traversal
            return null;
        }
        int j = index[0]; // pointer to traverse through dashes
        while (j < n && s.charAt(j) == '-') {
            j++;
        }
        int dashes = j - index[0];
        /**
         * if dashes and depth count do not match then we are at 
         * wrong node so return null
         */
        if (dashes != depth) {
            return null;
        }
        // here we are at correct node, so calculate node value
        index[0] = j;
        int num = 0;
        while (index[0] < n && Character.isDigit(s.charAt(index[0]))) {
            num = num * 10 + (s.charAt(index[0]) - '0');
            index[0]++;
        }
        // create the node
        TreeNode root = new TreeNode(num);
        // call the recursion for left sub-tree
        root.left = solve(s, index, depth + 1, n);
        // call the recursion for right sub-tree
        root.right = solve(s, index, depth + 1, n);
        // return the node
        return root;
    }
}
