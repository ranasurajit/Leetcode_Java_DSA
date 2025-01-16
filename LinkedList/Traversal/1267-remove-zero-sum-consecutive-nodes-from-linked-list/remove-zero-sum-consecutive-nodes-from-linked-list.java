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
     * Using Hashing on PrefixSum on ListNodes
     * 
     * TC: O(N ^ 2)
     * SC: O(N)
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        /**
         * we need to store prefixSum so we need to start with
         * prefixSum 0, so we would need a dummy node for the
         * same
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        /**
         * We would need to store the ListNodes with prefixSum and
         * so we need a HashMap<Integer, ListNode>
         */
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>(); // SC: O(N)
        map.put(prefixSum, dummy);
        // traverse the nodes
        ListNode current = head;
        while (current != null) { // TC: O(N)
            prefixSum += current.val;
            if (map.containsKey(prefixSum)) {
                // we need to remove all the nodes that cancels/nullifies nodes
                ListNode start = map.get(prefixSum);
                ListNode temp = start.next;
                int pSum = prefixSum;
                while (temp != current) { // TC: O(N)
                    pSum += temp.val;
                    if (temp != current) {
                        map.remove(pSum);
                    }
                    temp = temp.next;
                }
                start.next = current.next;
            } else {
                map.put(prefixSum, current);
            }
            current = current.next;
        }
        return dummy.next;
    }
}
