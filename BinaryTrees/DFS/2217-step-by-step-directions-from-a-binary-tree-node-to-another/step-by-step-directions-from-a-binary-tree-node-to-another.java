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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String directions = "";
        StringBuilder sb1 = new StringBuilder();
        findPath(root, startValue, sb1);
        StringBuilder sb2 = new StringBuilder();
        findPath(root, destValue, sb2);
        int p = 0;
        int q = 0;
        while (p < sb1.length() && q < sb2.length()) {
            if (sb1.charAt(p) != sb2.charAt(q)) {
                break;
            }
            p++;
            q++;
        }
        for (int i = p; i < sb1.length(); i++) {
            directions += "U";
        }
        for (int i = q; i < sb2.length(); i++) {
            directions += "" + sb2.charAt(i);
        }
        return directions;
    }

    private boolean findPath(TreeNode root, int target, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        // explore left
        sb.append("L");
        if (findPath(root.left, target, sb)) {
            return true;
        }
        sb.setLength(sb.length() - 1);
        // explore right
        sb.append("R");
        if (findPath(root.right, target, sb)) {
            return true;
        }
        sb.setLength(sb.length() - 1);
        return false;
    }
}
