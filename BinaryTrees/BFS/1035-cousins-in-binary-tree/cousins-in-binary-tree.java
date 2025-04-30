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
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, int[]> nodeMap = new HashMap<Integer, int[]>(); // SC: O(N)
        Queue<Pair> queue = new LinkedList<Pair>(); // SC: O(N)
        queue.offer(new Pair(root, -1, 0));
        while (!queue.isEmpty()) { // TC: O(N)
            Pair current = queue.poll();
            TreeNode node = current.node;
            int parent = current.parent;
            int level = current.level;
            nodeMap.put(node.val, new int[] { parent, level });
            if (node.left != null) {
                queue.offer(new Pair(node.left, node.val, level + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, node.val, level + 1));
            }
        }
        int[] xData = nodeMap.get(x);
        int[] yData = nodeMap.get(y);
        return xData[0] != yData[0] && xData[1] == yData[1];
    }

    static class Pair {
        TreeNode node;
        int parent;
        int level;

        public Pair (TreeNode node, int parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }
}
