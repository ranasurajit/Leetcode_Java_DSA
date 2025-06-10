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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        int count = 0;
        while (fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        ListNode prev = null;
        while (slow != null && fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
