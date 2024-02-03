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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        String preStr = printOrder(root, "pre");
        String postStr = printOrder(root, "post");
        return preStr.equals(postStr);
    }

    private String printOrder(TreeNode node, String type) {
        if (node == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val + "^");
        if (type.equals("pre")) {
            sb.append(printOrder(node.left, "pre") + "^");
            sb.append(printOrder(node.right, "pre") + "^");
        } else {
            sb.append(printOrder(node.right, "post") + "^");
            sb.append(printOrder(node.left, "post") + "^");
        }
        return sb.toString();
    }
}