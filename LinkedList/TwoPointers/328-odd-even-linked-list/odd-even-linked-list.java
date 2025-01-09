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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next; // storing even node's head
        // node pointers to traverse
        ListNode oddNode = head;
        ListNode evenNode = evenHead;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            evenNode.next = evenNode.next.next;
            // move both odd and even node pointers
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        // appending even node head to odd node's end
        oddNode.next = evenHead;
        return head;
    }
}
