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
     * Approach II : Using DFS and Tracking Depth Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaNode(root).node;
    }

    private TreePair lcaNode(TreeNode node) {
        if (node == null) {
            return new TreePair(null, 0);
        }
        TreePair left = lcaNode(node.left);
        TreePair right = lcaNode(node.right);
        if (left.depth == right.depth) {
            return new TreePair(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new TreePair(left.node, left.depth + 1);
        } else {
            return new TreePair(right.node, right.depth + 1);
        }
    }

    class TreePair {
        TreeNode node;
        int depth;

        public TreePair (TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * Approach I : Using BFS and DFS Approach
     *
     * TC: O(2 x N + log(N)) ~ O(N)
     * SC: O(2 x N + log(N)) ~ O(N)
     */
    public TreeNode lcaDeepestLeavesApproachI(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(log(N))
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                map.computeIfAbsent(level, k -> new ArrayList<Integer>()).add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;
        }
        int maxLevel = 0;
        for (Integer key : map.keySet()) { // TC: O(H) ~ O(log(N))
            maxLevel = Math.max(maxLevel, key);
        }
        ArrayList<Integer> deepestLevel = map.get(maxLevel); // TC: O(1)
        /**
         * LCA of deepest leaves will be the LCA (leftmost node, rightmost node)
         * values of deepest leaves
         * we are considering values here as mentioned in constraints
         * that "The values of the nodes in the tree are unique."
         */
        TreeNode lca = findLCA(root, 
            deepestLevel.get(0), 
            deepestLevel.get(deepestLevel.size() - 1)); // TC: O(N), SC: O(N)
        return lca;
    }

    /**
     * Using DFS Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private TreeNode findLCA(TreeNode root, int p, int q) {
        // Base Case
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        // DFS Approach
        TreeNode leftChild = findLCA(root.left, p, q);
        TreeNode rightChild = findLCA(root.right, p, q);
        if (leftChild != null && rightChild != null) {
            return root;
        }
        return leftChild == null ? rightChild : leftChild;
    }
}
