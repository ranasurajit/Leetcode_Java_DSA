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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currentNode = current.node;
            int level = current.level;
            if (!hm.containsKey(level)) {
                hm.put(level, 0);
            }
            hm.put(level, hm.get(level) + currentNode.val);
            if (currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, level + 1));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, level + 1));
            }
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        return index + 1;
    }

    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
