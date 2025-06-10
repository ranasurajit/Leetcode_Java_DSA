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
     * Approach : Using Two Pointers (Fast and Slow Pointers) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        /**
         * if there is a cycle, then both slow and fast pointer will meet
         * otherwise fast or fast.next will be null
         * move fast pointer by 2 steps and slow pointer by 1 step
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // no cycle present at all
            return null;
        }
        /**
         * at this point slow and fast coincided, so now set slow back to 
         * head and then move both pointers by 1 step
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
