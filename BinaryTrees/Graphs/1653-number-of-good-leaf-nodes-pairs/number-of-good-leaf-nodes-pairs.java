/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode, ArrayList<TreeNode>> adj = new HashMap<TreeNode, ArrayList<TreeNode>>();
        HashSet<TreeNode> leafs = new HashSet<TreeNode>();
        makeGraph(root, null, adj, leafs);
        int pairs = 0;

        for (TreeNode leaf : leafs) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            HashSet<TreeNode> visited = new HashSet<TreeNode>();
            queue.offer(leaf);
            visited.add(leaf);

            for (int level = 0; level <= distance; level++) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode current = queue.poll();
                    if (current != leaf && leafs.contains(current)) {
                        pairs++;
                    }
                    for (TreeNode neighbor : adj.getOrDefault(current, 
                        new ArrayList<TreeNode>())) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                    size--;
                }
            }
        }
        return pairs / 2;
    }

    private void makeGraph(TreeNode root, TreeNode prev, 
        HashMap<TreeNode, ArrayList<TreeNode>> adj, HashSet<TreeNode> leafs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafs.add(root);
        }
        if (!adj.containsKey(root)) {
            adj.put(root, new ArrayList<TreeNode>());
        }
        if (prev != null) {
            if (!adj.containsKey(prev)) {
                adj.put(prev, new ArrayList<TreeNode>());
            }
            adj.get(root).add(prev);
            adj.get(prev).add(root);
        }
        makeGraph(root.left, root, adj, leafs);
        makeGraph(root.right, root, adj, leafs);
    }
}
