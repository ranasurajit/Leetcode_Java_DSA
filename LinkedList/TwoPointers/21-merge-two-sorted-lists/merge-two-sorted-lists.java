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
     * Iterative Approach
     * 
     * TC: O(M + N)
     * SC: O(1)
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = list1;
        ListNode q = list2;

        // Create a node reference to return
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy; // pointer to traverse
        while (p != null && q != null) {
            if (p.val < q.val) {
                temp.next = p;
                p = p.next;
            } else {
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }
        // check if any of the pointer is not yet null
        while (p != null) {
            temp.next = p;
            p = p.next;
            temp = temp.next;
        }
        while (q != null) {
            temp.next = q;
            q = q.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
