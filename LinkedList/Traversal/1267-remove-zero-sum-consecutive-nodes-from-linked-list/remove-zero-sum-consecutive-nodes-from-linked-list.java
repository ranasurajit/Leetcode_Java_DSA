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
        ListNode dummy = new ListNode(0); // needed to add prefixSum = 0 node to HashMap
        dummy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>(); // SC: O(N)
        map.put(0, dummy);
        int prefixSum = 0;
        // start the traversal
        ListNode current = head;
        while (current != null) { // TC: O(N)
            prefixSum += current.val;
            if (map.containsKey(prefixSum)) {
                // here we need to delete the nodes which nullfies other nodes
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
