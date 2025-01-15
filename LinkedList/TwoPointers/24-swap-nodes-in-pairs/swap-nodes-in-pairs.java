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
     * Using Recursion
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        if (nextNode != null) {
            head.next = swapPairs(nextNode.next);
        }
        nextNode.next = head;
        return nextNode;
    }
}
