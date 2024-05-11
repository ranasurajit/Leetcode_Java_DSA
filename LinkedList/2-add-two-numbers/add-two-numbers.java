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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = null;
        ListNode tempNode = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            int sum = (carry + temp) % 10;
            carry = (carry + temp) / 10;
            ListNode node = new ListNode(sum);
            if (sumList == null && tempNode == null) {
                sumList = tempNode = node;
            } else {
                tempNode.next = node;
                tempNode = tempNode.next;
            }
        }
        if (carry > 0) {
            tempNode.next = new ListNode(carry);
        }
        return sumList;
    }
}
