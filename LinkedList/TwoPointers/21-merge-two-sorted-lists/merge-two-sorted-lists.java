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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                temp.next = p;
                temp = temp.next;
                p = p.next;
            } else {
                temp.next = q;
                temp = temp.next;
                q = q.next;
            }
        }
        if (p != null) {
            temp.next = p;
        }
        if (q != null) {
            temp.next = q;
        }
        return dummy.next;
    }
}
