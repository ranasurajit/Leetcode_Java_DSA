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
     * Approach : Using LinkedList Traversal Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int getDecimalValue(ListNode head) {
        // we need to find the length of the LinkedList
        int length = 0;
        ListNode current = head;
        while (current != null) { // TC: O(N)
            length++;
            current = current.next;
        }
        // now we need to traverse in the LinkedList to calculate the decimal number
        int decNum = 0;
        current = head;
        while (current != null) { // TC: O(N)
            decNum += current.val * (1 << (length - 1));
            current = current.next;
            length--;
        }
        return decNum;
    }
}
