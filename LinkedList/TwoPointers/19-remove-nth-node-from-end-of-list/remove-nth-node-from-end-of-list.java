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
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        // move the fast node forward by n steps
        int count = 0;
        while (fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        // now move slow and fast pointers by 1 step
        while (fast != null && fast.next != null) {    // TC: O(N)
            slow = slow.next;
            fast = fast.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next; // skipping the nth node from last
        }
        return dummy.next;
    }
}
