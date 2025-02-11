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
     * Using DFS Approach
     *
     * TC: O(N + K)
     * SC: O(N + K)
     * where K = number of possible paths
     * 
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); // SC: O(K)
        solve(root, 0, list);
        int sumTree = 0;
        for (Integer it : list) { // TC: O(K)
            sumTree += it;
        }
        return sumTree;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     * @param sum
     * @param list
     */
    private void solve(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        // if node is a leaft node
        if (root.left == null && root.right == null) {
            list.add(sum);
        }
        // call recursion for left sub-tree
        solve(root.left, sum, list);
        // call recursion for right sub-tree
        solve(root.right, sum, list);
        // backtrack
        sum -= root.val;
    }
}
