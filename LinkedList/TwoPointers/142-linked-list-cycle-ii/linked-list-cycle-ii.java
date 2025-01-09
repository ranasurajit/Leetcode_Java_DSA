/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Using Slow and Fast pointers approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        // move the slow pointer by 1 step and fast pointer by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // here if fast and slow pointer meet then there is a cycle
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            // there is no cycle
            return null;
        }
        // assign fast to head and move both pointers by 1 step each
        fast = head;
        while (slow != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
