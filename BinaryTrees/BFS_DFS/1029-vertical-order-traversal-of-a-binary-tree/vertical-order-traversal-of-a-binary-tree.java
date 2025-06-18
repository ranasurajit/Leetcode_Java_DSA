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
    /**
     * Approach : Using BFS Approach
     *
     * TC: O(N x log(K) + K x log(K))
     * SC: O(2 x N + K) ~ O(N + K)
     *
     * where K is the Max(columns)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        if (root == null) {
            return path;
        }
        List<int[]> nodes = new ArrayList<int[]>(); // SC: O(N)
        Queue<Pair> queue = new LinkedList<Pair>(); // SC: O(N)
        queue.offer(new Pair(root, 0, 0));
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int row = current.row;
                int col = current.col;
                nodes.add(new int[] { node.val, row, col });
                if (node.left != null) {
                    queue.offer(new Pair(node.left, row + 1, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, row + 1, col + 1));
                }
            }
            level++;
        }
        Collections.sort(nodes, (int[] a, int[] b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        }); // TC: O(N x log(N))
        TreeMap<Integer, ArrayList<Integer>> tmap = 
            new TreeMap<Integer, ArrayList<Integer>>(); // SC: O(K)
        for (int[] node : nodes) { // TC: O(N)
            tmap.computeIfAbsent(node[2], 
                k -> new ArrayList<Integer>()).add(node[0]); // TC: O(log(K))
        }
        for (Integer key : tmap.keySet()) { // TC: O(K)
            path.add(tmap.get(key)); // TC: O(log(K))
        }
        return path;
    }

    static class Pair {
        TreeNode node;
        int row;
        int col;

        public Pair (TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
