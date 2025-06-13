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
     * Approach : Using Two Pointers Approach
     *
     * TC: O(K x (N / K))
     * SC: O(N / K)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        while (count < k && current != null) { // TC: O(K)
            prev = current;
            current = current.next;
            count++;
        }
        // prev pointer has the end of 1st segment and current pointer is the start of next segment
        // remove next pointer of prev to separate the list segment
        if (prev == null) {
            return head;
        }
        prev.next = null;
        // reverse the list (if count == k)
        ListNode reversedList = count == k ? reverseLL(head) : head; // TC: O(K)
        ListNode nextSegmentListNode = reverseKGroup(current, k); // TC: O(K)
        ListNode temp = reversedList;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        // at this point we have the tail of reversed Linked-List segment
        temp.next = nextSegmentListNode;
        return reversedList;
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(K)
     * SC: O(1)
     */
    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
