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
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<Node, Node>(); // SC: O(N)
        Node current = head;
        // creating a HashMap to create related copies of actual nodes mapped to it
        while (current != null) { // TC: O(N)
            map.put(current, new Node(current.val));
            current = current.next;
        }
        // copying next and random pointers in the below loop
        current = head;
        while (current != null) { // TC: O(N)
            Node clonedNode = map.get(current);
            // copy the next nodes
            clonedNode.next = map.get(current.next);
            // copy the random pointers
            clonedNode.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
