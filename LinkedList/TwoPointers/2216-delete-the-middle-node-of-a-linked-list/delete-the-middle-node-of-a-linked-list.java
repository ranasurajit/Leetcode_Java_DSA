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
     * Approach II : Using Two Pointers (Fast and Slow Pointers Cleaner Approach) Approach
     *
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N / 2)
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    /**
     * Approach I : Using Two Pointers (Fast and Slow Pointers) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode deleteMiddleTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N / 2)
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow pointer has the middle node
        ListNode prev = null;
        ListNode current = head;
        while (current != slow) { // TC: O(N / 2)
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        return head;
    }
}
