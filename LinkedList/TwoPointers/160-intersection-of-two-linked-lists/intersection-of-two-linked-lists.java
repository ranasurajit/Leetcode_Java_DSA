/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * Approach : Using Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode slow = headA; // pointer at the start of list A
        ListNode fast = headB; // pointer at the start of list B
        while (slow != fast) { // TC: O(2 x N)
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                // return the node at which both pointers meet
                break;
            }
            // switch the pointers at the other end
            if (slow == null) {
                slow = headB;
            }
            if (fast == null) {
                fast = headA;
            }
        }
        return slow;
    }
}
