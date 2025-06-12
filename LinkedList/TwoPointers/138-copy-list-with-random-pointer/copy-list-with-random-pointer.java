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
     * Approach II : Using Pointer Linking Approach (Without Extra Space)
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // creating criss-cross linking with duplicate nodes to ease copying random pointers
        Node current = head;
        while (current != null) { // TC: O(N)
            Node temp = current.next;
            current.next = new Node(current.val);
            current.next.next = temp;
            current = current.next.next;
        }
        // copying random pointers
        current = head;
        while (current != null && current.next != null) { // TC: O(N)
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }
        // retaining the original and copied lists and removing criss-cross linkages/adding next pointers
        Node original = head;
        Node copied = head.next;
        Node copiedHead = copied;
        while (original != null && copied != null) { // TC: O(N)
            original.next = original.next != null ? original.next.next : null;
            copied.next = copied.next != null ? copied.next.next : null;
            original = original.next;
            copied = copied.next;
        }
        return copiedHead;
    }

    /**
     * Approach I : Using Hashing Approach (Uses Extra Space)
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public Node copyRandomListUsingHashing(Node head) {
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
