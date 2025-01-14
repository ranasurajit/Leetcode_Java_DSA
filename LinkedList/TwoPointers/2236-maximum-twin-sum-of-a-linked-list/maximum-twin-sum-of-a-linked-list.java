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
     * Using Slow and Fast Pointers and Reversing Linked-List Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode mid = middle(head); // TC: O(N / 2)
        ListNode rev = reverse(mid); // TC: O(N)
        int currentSum = 0;
        int maxSum = 0;
        ListNode headCurrent = head;
        ListNode revCurrent = rev;
        while (revCurrent != null) { // TC: O(N / 2)
            currentSum = headCurrent.val + revCurrent.val;
            maxSum = Math.max(maxSum, currentSum);
            headCurrent = headCurrent.next;
            revCurrent = revCurrent.next;
        }
        return maxSum;
    }

    /**
     * Using Iterative Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * Using Slow and Fast Pointers Approach
     *
     * TC: O(N / 2)
     * SC: O(1)
     */
    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
