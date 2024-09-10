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
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;
        // TC: O(2 x N) ~ O(N)
        while (current != null) {
            int gcd = getGCD(current.val, prev.val);
            prev.next = new ListNode(gcd);
            prev.next.next = current;
            prev = current;
            current = current.next;
        }
        return head;
    }

    private int getGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        } else if (a > b) {
            return getGCD(a % b, b);
        } else {
            return getGCD(b % a, a);
        }
    }
}
