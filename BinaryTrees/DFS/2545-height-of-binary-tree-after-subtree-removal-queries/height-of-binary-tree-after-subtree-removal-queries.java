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
     * TC: O(N + Q)
     * SC: O(2 x N) ~ O(N)
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        if (root == null) {
            return result;
        }
        HashMap<Integer, Pair> nodeLevels = new HashMap<Integer, Pair>();    // SC: O(N)
        HashMap<Integer, TopTwo> topLevels = new HashMap<Integer, TopTwo>(); // SC: O(N)
        findNodeHeight(root, 0, nodeLevels, topLevels);                      // TC: O(N)
        for (int i = 0; i < n; i++) {                                        // TC: O(Q)
            int query = queries[i];
            int level = nodeLevels.get(query).level;
            int height = nodeLevels.get(query).height;
            int maxHeight = topLevels.get(level).first == height ? 
                topLevels.get(level).second : topLevels.get(level).first;
            result[i] = maxHeight + level - 1;
        }
        return result;
    }

    private int findNodeHeight(TreeNode root, int level, 
        HashMap<Integer, Pair> nodeLevels,
        HashMap<Integer, TopTwo> topLevels) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.max(findNodeHeight(root.left, level + 1, nodeLevels, topLevels),
                                  findNodeHeight(root.right, level + 1, nodeLevels, topLevels));
        nodeLevels.put(root.val, new Pair(level, height));
        if (height > topLevels.getOrDefault(level, new TopTwo(0, 0)).first) {
            topLevels.put(level, 
                new TopTwo(height, topLevels.getOrDefault(level, new TopTwo(0, 0)).first));
        } else if (height > topLevels.get(level).second) {
            topLevels.get(level).second = height;
        }
        return height;
    }

    class TopTwo {
        int first;
        int second;
        public TopTwo (int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Pair {
        int level;
        int height;
        public Pair(int level, int height) {
            this.level = level;
            this.height = height;
        }
    }
}
