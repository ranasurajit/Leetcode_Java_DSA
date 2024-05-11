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
    public ListNode doubleIt(ListNode head) {
        ListNode revList = reverseLL(head);
        ListNode current = revList;
        int carry = 0;
        while (current != null) {
            int temp = carry + (current.val * 2);
            current.val = temp % 10;
            carry = temp / 10;
            current = current.next;
        }
        ListNode result = null;
        if (carry > 0) {
            result = new ListNode(carry);
            result.next = reverseLL(revList);
        } else {
            result = reverseLL(revList);
        }
        return result;
    }

    private ListNode reverseLL(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
