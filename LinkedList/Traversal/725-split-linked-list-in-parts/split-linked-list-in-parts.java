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
     * TC: O(N + k x N) ~ O(k x N)
     * SC: O(1)
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] splits = new ListNode[k];
        int length = getSize(head); // TC: O(N)
        int splitSize = length / k;
        int rem = length % k;
        for (int i = 0; i < k; i++) { // TC: O(k x N) 
            ListNode current = head;
            ListNode prev = null;
            int count = splitSize;
            if (rem > 0) {
                count = splitSize + 1;
            }
            while (current != null && count > 0) {
                prev = current;
                current = current.next;
                count--;
            }
            if (prev != null) {
                prev.next = null;
            }
            splits[i] = head;
            head = current;
            rem--;
        }
        return splits;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private int getSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
