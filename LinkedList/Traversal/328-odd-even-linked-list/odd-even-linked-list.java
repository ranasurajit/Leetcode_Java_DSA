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
     * Approach II : Using Traversal of Linked-List Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode current = head;
        int count = 1;
        while (current != null) {
            if ((count & 1) != 0) {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            }
            current = current.next;
            count++;
        }
        if (evenHead == null) {
            return oddHead;
        }
        if (oddHead == null) {
            return evenHead;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }

    /**
     * Approach I : Using Traversal of Linked-List (Extra Space) Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public ListNode oddEvenListUsingExtraSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode current = head;
        int count = 1;
        while (current != null) { // TC: O(N)
            if ((count & 1) == 1) {
                // odd count
                oddTail.next = new ListNode(current.val);
                oddTail = oddTail.next;
            } else {
                // even count
                evenTail.next = new ListNode(current.val);
                evenTail = evenTail.next;
            }
            current = current.next;
            count++;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
