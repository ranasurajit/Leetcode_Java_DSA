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

    List<Integer> list;
    Random random;

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public Solution(ListNode head) {
        list = new ArrayList<Integer>();
        random = new Random();

        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int getRandom() {
        int n = list.size();
        int randomIndex = random.nextInt(n);
        return list.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
