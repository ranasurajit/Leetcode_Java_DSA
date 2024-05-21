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
    // BFS Solution
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) {
            return view;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currentNode = current.node;
            int level = current.level;
            if (!hm.containsKey(level)) {
                hm.put(level, currentNode.val);
            }
            if (currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, level + 1));
            }
            if (currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, level + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            view.add(entry.getValue());
        }
        return view;
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
