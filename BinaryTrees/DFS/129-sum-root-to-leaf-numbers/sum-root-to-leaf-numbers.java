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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int total = 0;
        List<Integer> list = new ArrayList<Integer>();
        dfsTree(root, sum, list);
        for (Integer it : list) {
            total += it;
        }
        return total;
    }

    private void dfsTree(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            list.add(sum);
            return;
        }
        dfsTree(node.left, sum * 10, list);
        dfsTree(node.right, sum * 10, list);
    }
}
