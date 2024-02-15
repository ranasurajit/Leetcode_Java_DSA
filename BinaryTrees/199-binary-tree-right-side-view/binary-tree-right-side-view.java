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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int level = current.level;
            TreeNode node = current.node;
            map.put(level, node.val);
            if (node.left != null) {
                queue.offer(new Pair(level + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair(level + 1, node.right));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}