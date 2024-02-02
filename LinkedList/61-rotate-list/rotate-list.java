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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int iter = 0;
        int length = 0;
        while (slow != null && slow.next != null) {
            slow = slow.next;
            length++;
        }
        if (k % length == 0) {
            return head;
        }
        k = k % length;
        slow = dummy;
        while (fast != null && iter < k) {
            fast = fast.next;
            iter++;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp != null && dummy != null)
            temp.next = dummy.next;
        return newHead;
    }
}