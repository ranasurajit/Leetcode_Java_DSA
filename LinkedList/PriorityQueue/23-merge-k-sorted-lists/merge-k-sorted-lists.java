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
     * Approach : Using Min-Heap Approach
     *
     * TC: O(K + K x L), where L = average length of K sorted lists
     * SC: O(K)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        // we will be adding the head of 'k' sorted lists to Min-Heap (PriorityQueue)
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((p, q) -> p.val - q.val); // SC: O(K)
        for (int i = 0; i < k; i++) { // TC: O(K)
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) { // TC: O(K x L)
            ListNode temp = pq.poll();
            current.next = temp;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
            current = current.next;
        }
        return dummy.next;
    }
}
