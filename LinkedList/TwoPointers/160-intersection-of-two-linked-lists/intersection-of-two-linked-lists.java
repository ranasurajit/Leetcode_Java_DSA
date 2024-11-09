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
     * TC: O(2 x M + 2 x N) ~ O(M + N)
     * SC: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        } 
        if (headA == headB) {
            return headA;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
            if (currA == currB) {
                return currA;
            }
            if (currA == null) {
                currA = headB;
            }
            if (currB == null) {
                currB = headA;
            }
        }
        return currA;
    }
}
