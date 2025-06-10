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
     * Approach I : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public ListNode reverseList(ListNode head) {
        return solveRecursion(head);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private ListNode solveRecursion(ListNode head) {
        // Base Case
        if (head == null || head.next == null) {
            return head;
        }
        // Recursion Calls
        // we will assume that Recursion will return a new head with reversed list of size (n - 1)
        ListNode headNext = head.next;
        head.next = null;
        ListNode revHead = solveRecursion(headNext);
        headNext.next = head;
        return revHead;
    }
}
