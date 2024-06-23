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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        int count = k;
        while (current != null && count > 0) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count--;
        }
        if (current == null && count > 0) {
            current = prev;
            prev = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
        }
        if (count > 0) {
            return prev;
        } else {
            head.next = reverseKGroup(current, k);
        }
        return prev;
    }
}
