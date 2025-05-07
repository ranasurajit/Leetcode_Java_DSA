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
     * Approach : Using Recursion
     *
     * TC: O(N)
     * SC: O(N)
     */
    public ListNode reverseList(ListNode head) {
        return solveRecursion(head);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    private ListNode solveRecursion(ListNode head) {
        // Base Case
        if (head == null || head.next == null) {
            return head;
        }
        // Hypothesis
        /** 
         * we assume that recursion will return me reversed 
         * LinkedList from (head.next till last and return 
         * a new head)
         */
        ListNode tail = head.next; // stored reference of next node
        head.next = null;
        ListNode newHead = solveRecursion(tail);
        // Induction
        tail.next = head;
        return newHead;
    }
}
