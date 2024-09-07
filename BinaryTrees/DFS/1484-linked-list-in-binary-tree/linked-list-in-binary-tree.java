/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
     * TC: O(N x M), where N and M are number of nodes of Binary Tree and LinkedList respectively
     * SC: O(N + M)
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            // did not find sub-path
            return false;
        }
        return compareNodes(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean compareNodes(ListNode head, TreeNode root) {
        if (head == null) {
            // LinkedList traversal is complete i.e. sub-path exists
            return true;
        }
        if (root == null) {
            // sub-path do not exist
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return compareNodes(head.next, root.left) || compareNodes(head.next, root.right);
    }
}
