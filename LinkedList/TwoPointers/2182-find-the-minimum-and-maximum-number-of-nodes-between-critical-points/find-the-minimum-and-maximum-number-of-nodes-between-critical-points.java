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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[2];
        int[] defaultValue = { -1, -1 };
        List<Integer> list = new ArrayList<Integer>();
        ListNode prev = head;
        ListNode current = prev.next;
        ListNode next = current.next;
        int count = 2;
        while (next != null) {
            if (current.val > prev.val && current.val > next.val) {
                list.add(count);
            }
            if (current.val < prev.val && current.val < next.val) {
                list.add(count);
            }
            prev = current;
            current = next;
            next = next.next;
            count++;
        }
        int n = list.size();
        if (n == 0) {
            return defaultValue;
        }
        int max = list.get(n - 1) - list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            int diff = list.get(i) - list.get(i - 1);
            min = Math.min(min, diff);
        }
        if (min == Integer.MAX_VALUE) {
            return defaultValue;
        }
        result[0] = min;
        result[1] = max;
        return result;
    }
}
