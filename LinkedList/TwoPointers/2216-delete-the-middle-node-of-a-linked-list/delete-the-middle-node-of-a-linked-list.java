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
     * Using Fast and Slow Pointers approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid of the linked-list is at slow pointer
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {                   // TC: O(N)
            if (prev != null && prev.next == slow) {
                // if the prev.next pointer is at middle node of LinkedList
                prev.next = prev.next.next;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }
}
