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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<Integer, TreeNode>();
        Set<Integer> children = new HashSet<Integer>();
        for (int[] pair : descriptions) {
            if (!hm.containsKey(pair[0])) {
                hm.put(pair[0], new TreeNode(pair[0]));
            }
            if (!hm.containsKey(pair[1])) {
                hm.put(pair[1], new TreeNode(pair[1]));
                children.add(pair[1]);
            } else {
                children.add(pair[1]);
            }
            TreeNode child = hm.get(pair[1]);
            if (pair[2] == 1) {
                hm.get(pair[0]).left = child;
            } else {
                hm.get(pair[0]).right = child;
            }
        }
        TreeNode root = null;
        for (Integer key : hm.keySet()) {
            if (!children.contains(key)) {
                root = hm.get(key);
            }
        }
        return root;
    }
}
