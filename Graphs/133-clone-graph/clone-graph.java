/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node newNode = cloneHelper(node, map);
        return newNode;
    }

    private Node cloneHelper(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node current = new Node(node.val);
        map.put(node, current);
        for (Node n : node.neighbors) {
            if (map.containsKey(n)) {
                current.neighbors.add(map.get(n));
            } else {
                current.neighbors.add(cloneHelper(n, map));
            }
        }
        return current;
    }
}