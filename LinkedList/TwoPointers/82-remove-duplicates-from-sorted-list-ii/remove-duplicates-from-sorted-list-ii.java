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
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) { // TC: O(N)
            if (current.next != null && current.next.val == current.val) {
                int value = current.val;
                while (current != null && current.val == value) {
                    current = current.next;
                }
                if (prev == null) {
                    head = current;
                } else {
                    prev.next = current;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}
