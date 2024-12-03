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
     * TC: O(N)
     * SC: O(1)
     */
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null && current.next != null) {
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }
}
