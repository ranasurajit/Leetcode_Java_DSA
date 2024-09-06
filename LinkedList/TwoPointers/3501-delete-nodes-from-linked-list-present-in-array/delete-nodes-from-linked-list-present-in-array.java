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
     * TC: O(N)
     * SC: O(K), where K = length of nums
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) {
            return null;
        }
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }
        while (head != null && hs.contains(head.val)) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (hs.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
