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
        if (head == null) {
            return null;
        }
        ListNode reverseHead = reverseLL(head);
        ListNode current = reverseHead;
        int carry = 0;
        while (current != null) {
            int temp = 2 * current.val;
            current.val = carry + temp % 10;
            carry = temp / 10;
            current = current.next;
        }
        ListNode doubleNumLL = reverseLL(reverseHead);
        if (carry > 0) {
            ListNode doubleCarryNumLL = new ListNode(carry);
            doubleCarryNumLL.next = doubleNumLL;
            return doubleCarryNumLL;
        } else {
            return doubleNumLL;
        }
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
