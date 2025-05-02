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
     * Approach II : Using BFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int childCount = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int sameParentCount = 0;
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                    if (current.left.val == x || current.left.val == y) {
                        sameParentCount++;
                        childCount++;
                    }
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    if (current.right.val == x || current.right.val == y) {
                        sameParentCount++;
                        childCount++;
                    }
                }
                // same level
                if (sameParentCount == 2) {
                    // we got both x and y in the same level
                    return false;
                }
            }
            // end of a level
            if (childCount == 2) {
                return true;
            } else if (childCount == 1) {
                // we might get the other node (x or y) in other level
                return false;
            }
        }
        return false;
    }

    /**
     * Approach I : Using BFS Approach
     * 
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean isCousinsApproachI(TreeNode root, int x, int y) {
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
