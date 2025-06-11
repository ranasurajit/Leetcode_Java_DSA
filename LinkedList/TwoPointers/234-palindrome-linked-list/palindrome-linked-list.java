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
     * Approach : Using Linked-List Traversal and Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) { // TC: O(N)
            length++;
            current = current.next;
        }
        boolean isEven = (length & 1) == 0;
        ListNode midNode = middleLL(head); // TC: O(N / 2)
        if (!isEven) {
            midNode = midNode.next;
        }
        ListNode revList = reverseLL(midNode);
        ListNode current1 = head;
        ListNode current2 = revList;
        while (current1 != null && current2 != null) { // TC: O(N / 2)
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    /**
     * Using Iterative Approach to Reverse the Linked-List
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) { // TC: O(N)
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * Using Two Pointers (Fast and Slow Pointers) Approach
     * 
     * TC: O(N / 2)
     * SC: O(1)
     */
    private ListNode middleLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
