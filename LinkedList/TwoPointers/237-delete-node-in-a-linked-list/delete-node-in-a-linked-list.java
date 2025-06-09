/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode prev = null;
        ListNode current = node;
        while (current != null && current.next != null) { // TC: O(N)
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }
}
