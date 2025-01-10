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

    ListNode temp;
    Random random;
    ArrayList<Integer> list;

    public Solution(ListNode head) {
        temp = head;
        random = new Random();
    }
    
    /**
     * Using Reservoir Sampling
     * TC: O(N)
     * SC: O(1)
     */
    public int getRandom() {
        ListNode current = temp;
        int result = 0;
        int size = 1;
        while (current != null) {
            // Reservoir sampling: probability of choosing current node = 1/size
            if (random.nextInt(size) == 0) {
                result = current.val;
            }
            size++;
            current = current.next;
        }
        return result;
    }

    /**
     * Using Brute-Force Approach
     * TC: O(N)
     * SC: O(N)
     */
    public void solution(ListNode head) {
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
    public int getRandomBrute() {
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
