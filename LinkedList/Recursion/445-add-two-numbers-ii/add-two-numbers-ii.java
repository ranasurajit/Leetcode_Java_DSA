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
     * Using Two Pointers and Recursion
     * 
     * TC: O(M + N), visits all the nodes
     * SC: O(M + N + Max(M, N))
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverseLinkedList(l1); // TC: O(M), SC: O(M)
        ListNode revL2 = reverseLinkedList(l2); // TC: O(N), SC: O(N)
        // Now we need to keep adding values to the sum LinkedList
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        /**
         * now till both LinkedList traversals exists keep
         * adding the sum and set the carry value
         */
        int carry = 0;
        while (revL1 != null && revL2 != null) {
            int sum = carry + revL1.val + revL2.val;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            revL1 = revL1.next;
            revL2 = revL2.next;
        }
        while (revL1 != null) {
            int sum = carry + revL1.val;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            revL1 = revL1.next;
        }
        while (revL2 != null) {
            int sum = carry + revL2.val;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            revL2 = revL2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        // finally reversing the result and returning it
        return reverseLinkedList(dummy.next); // TC: O(Max(M, N)), SC: O(Max(M, N))
    }

    /**
     * Using Recursion
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param head
     * @return
     */
    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseLinkedList(nextNode);
        head.next = null;
        nextNode.next = head;
        return newHead;
    }
}
