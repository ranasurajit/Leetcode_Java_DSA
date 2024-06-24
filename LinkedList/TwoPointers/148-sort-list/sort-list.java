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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findFirstMiddleLinkedList(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeSortedLists(leftHead, rightHead);
    }

    private ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = list1;
        ListNode t2 = list2;

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if (t1 == null) {
            temp.next = t2;
        }
        if (t2 == null) {
            temp.next = t1;
        }
        return dummy.next;
    }

    private ListNode findFirstMiddleLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
