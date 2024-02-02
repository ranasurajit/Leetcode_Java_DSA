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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1); 
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        int count = 0;
        while (fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow != null && slow.next != null)
            slow.next = slow.next.next;
        return dummy.next;
    }
}