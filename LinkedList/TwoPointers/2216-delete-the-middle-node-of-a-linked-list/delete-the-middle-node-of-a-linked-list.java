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
class Solution {
    /**
     * Using Two Pointers (Slow and Fast pointers)
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     * 
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N / 2)
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * here slow will be the mid of Linked List and prev node's
         * next will be the middle node so move it
         */
        prev.next = prev.next.next;
        return head;
    }
}
