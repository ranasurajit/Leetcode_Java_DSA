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
     * TC: O(2 x N + N x log(N)) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> view = new ArrayList<List<Integer>>();
        if (root == null) {
            return view;
        }
        List<int[]> nodes = new ArrayList<int[]>(); // SC: O(N)
        Queue<Pair> queue = new LinkedList<Pair>(); // SC: O(N)
        queue.offer(new Pair(root, 0, 0));
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode current = pair.node;
                int row = pair.row;
                int col = pair.col;
                nodes.add(new int[] { current.val, row, col });
                if (current.left != null) {
                    queue.offer(new Pair(current.left, row + 1, col - 1));
                }
                if (current.right != null) {
                    queue.offer(new Pair(current.right, row + 1, col + 1));
                }
            }
        }
        nodes.sort((int[] a, int[] b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        }); // TC: O(N x log(N))
        int prevCol = Integer.MIN_VALUE;
        for (int[] list : nodes) { // TC: O(N)
            int col = list[2];
            int val = list[0];
            if (prevCol != col) {
                view.add(new ArrayList<Integer>());
                prevCol = col;
            }
            view.get(view.size() - 1).add(val);
        }
        return view;
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
