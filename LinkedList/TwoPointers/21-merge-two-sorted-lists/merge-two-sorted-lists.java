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
     * Recursive Approach
     * 
     * TC: O(M + N)
     * SC: O(M + N)
     * 
     * where M and N are lengths of LinkedList list1 and list2 respectively
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
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * Iterative Approach
     * 
     * TC: O(M + N)
     * SC: O(1)
     * 
     * where M and N are lengths of LinkedList list1 and list2 respectively
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
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
        // check if any of the pointer is not yet null
        if (p != null) {
            temp.next = p;
        }
        if (q != null) {
            temp.next = q;
        }
        return dummy.next;
    }
}
