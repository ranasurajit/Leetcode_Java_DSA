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
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N / 2)
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // if at any time fast and slow pointers meet, then a cycle is present
                return true;
            }
        }
        return false;
    }
}
