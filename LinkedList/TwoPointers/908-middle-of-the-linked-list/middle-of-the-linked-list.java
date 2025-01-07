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
     * Using Two Pointers (Slow and Fast pointers)
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N / 2)
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow pointer will point to mid node of Linked List
        return slow;
    }
}
