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
     * Approach : Using Min-Heap (PriorityQueue) Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(N)
     */
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(N)
        ListNode current = head; 
        while (current != null) { // TC: O(N)
            pq.offer(current.val); // TC: O(log(N))
            current = current.next;
        }
        ListNode dummy = new ListNode(-1);
        current = dummy;
        while (!pq.isEmpty()) { // TC: O(N)
            current.next = new ListNode(pq.poll());
            current = current.next; 
        }
        return dummy.next;
    }
}
