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
    // DFS Solution
    public int maxLevelSum(TreeNode root) {
        List<Integer> sumLevels = new ArrayList<Integer>();
        dfsTree(root, 0, sumLevels);
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < sumLevels.size(); i++) {
            if (max < sumLevels.get(i)) {
                max = sumLevels.get(i);
                index = i;
            }
        }
        return index + 1;
    }

    private void dfsTree(TreeNode node, int level, List<Integer> sumLevels) {
        if (node == null) {
            return;
        }
        if (sumLevels.size() == level) {
            sumLevels.add(0);
        }
        sumLevels.set(level, sumLevels.get(level) + node.val);
        dfsTree(node.left, level + 1, sumLevels);
        dfsTree(node.right, level + 1, sumLevels);
    }
}
