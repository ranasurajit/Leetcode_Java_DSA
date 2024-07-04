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
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        if (head == null) {
            return head;
        }
        ListNode current = head;
        int sum = 0;
        while (current != null && current.val != 0) {
            sum += current.val;
            current = current.next;
        }
        head.val = sum;
        // Recursion Leap of Faith
        head.next = mergeNodes(current);
        return head;
    }
}
