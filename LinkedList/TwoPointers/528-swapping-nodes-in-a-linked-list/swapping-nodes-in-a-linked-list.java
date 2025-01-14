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
        ListNode first = head;
        ListNode second = head;

        while (count < k) { // TC: O(K)
            fast = fast.next;
            count++;
        }
        first = fast;
        while (fast != null && fast.next != null) { // TC: O(N - K)
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;
        // swap values of first and second ListNodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
