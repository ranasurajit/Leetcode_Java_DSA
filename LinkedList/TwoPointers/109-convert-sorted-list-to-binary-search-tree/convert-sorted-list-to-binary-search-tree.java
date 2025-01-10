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
     * Using Recursion (runs till height of tree = log(N))
     * 
     * TC: O(N x log(N))
     * SC: O(log(N))
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return makeTree(head);
    }

    /**
     * Using Recursion (runs till height of tree = log(N))
     * 
     * TC: O(N x log(N))
     * SC: O(log(N))
     */
    private TreeNode makeTree(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode[] middle = middleOfLinkedList(head); // TC: O(N)
        ListNode prev = middle[0];
        ListNode mid = middle[1];
        TreeNode root = new TreeNode(mid.val);
        root.left = makeTree(head);
        root.right = makeTree(mid.next);
        return root;
    }

    /**
     * Using Slow and Fast pointers approach
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    private ListNode[] middleOfLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        // moving slow pointer by 1 step and fast pointer by 2 steps
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // remove next pointers from prev
        if (prev != null) {
            prev.next = null;
        }
        return new ListNode[] { prev, slow };
    }
}
