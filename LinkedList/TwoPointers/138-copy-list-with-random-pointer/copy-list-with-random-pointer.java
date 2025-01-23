/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /**
     * Using Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // store the node references of head and newHead
        Map<Node, Node> map = new HashMap<Node, Node>(); // SC: O(N)
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node current = head;
        // traversing to copy only next nodes
        while (current != null) { // TC: O(N)
            temp.next = new Node(current.val);
            map.put(current, temp.next);
            // moving both the pointers
            temp = temp.next;
            current = current.next;
        }
        // setting random pointers
        current = head;
        temp = dummy.next;
        while (current != null) { // TC: O(N)
            // setting the random pointers from references from HashMap
            Node random = current.random;
            temp.random = map.get(random);
            temp = temp.next;
            current = current.next;
        }
        return dummy.next;
    }
}
