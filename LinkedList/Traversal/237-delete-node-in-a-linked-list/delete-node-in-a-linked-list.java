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
     * 
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node != null && node.next != null) { // TC: O(N)
            // setting the node value to node's next value so that target node value is
            // deleted
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
