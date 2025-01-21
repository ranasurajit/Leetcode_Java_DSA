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
     * Using Monotonic Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new int[] { 0 };
        }
        List<Integer> nums = new ArrayList<Integer>(); // SC: O(N)
        ListNode current = head;
        while (current != null) {                      // TC: O(N)
            nums.add(current.val);
            current = current.next;
        }
        return nextGreaterElement(nums);               // TC: O(N), SC: O(N)
    }

    /**
     * Using Monotonic Stack Approach
     *
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    private int[] nextGreaterElement(List<Integer> nums) {
        int n = nums.size();
        int[] nge = new int[n];                   // SC: O(N)
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) {        // TC: O(N)
            while (!st.isEmpty() && st.peek() <= nums.get(i)) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? 0 : st.peek();
            st.add(nums.get(i));
        }
        return nge;
    }
}
