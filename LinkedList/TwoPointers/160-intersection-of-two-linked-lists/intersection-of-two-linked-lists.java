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
        // If both heads are same
        if (headA == headB) {
            return headA;
        }
        // Setting up two pointers at the start of each head ListNode
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != currentB) { // TC: O(2 x N)
            currentA = currentA.next;
            currentB = currentB.next;
            if (currentA == currentB) {
                break;
            }
            if (currentA == null) {
                currentA = headB;
            }
            if (currentB == null) {
                currentB = headA;
            }
        }
        return currentA;
    }
}
