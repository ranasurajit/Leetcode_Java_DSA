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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        TreeMap<Integer, ArrayList<Integer>> tMap = new TreeMap<Integer, ArrayList<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, root));

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int level = current.level;
            TreeNode currentNode = current.node;
            if (!tMap.containsKey(level)) {
                tMap.put(level, new ArrayList<Integer>());
            }
            tMap.get(level).add(currentNode.val);

            if (currentNode.left != null) {
                queue.offer(new Pair(level - 1, currentNode.left));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair(level - 1, currentNode.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : tMap.entrySet()) {
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
