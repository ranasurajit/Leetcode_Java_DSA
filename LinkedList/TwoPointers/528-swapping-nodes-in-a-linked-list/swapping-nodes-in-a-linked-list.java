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
     * Using Slow and Fast Pointers Approach
     *
     * TC: O(N + K)
     * SC: O(1)
     */
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode slow = head;
        ListNode fast = head;
        while (count < k) { // TC: O(K)
            fast = fast.next;
            count++;
        }
        int firstValue = fast.val;
        while (fast != null && fast.next != null) { // TC: O(N - K)
            slow = slow.next;
            fast = fast.next;
        }
        int lastValue = slow.val;
        slow.val = firstValue;
        fast = head;
        count = 1;
        while (count < k) { // TC: O(K)
            fast = fast.next;
            count++;
        }
        fast.val = lastValue;
        return head;
    }
}
