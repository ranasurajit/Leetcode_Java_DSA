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
    public TreeNode balanceBST(TreeNode root) {
        /*
         * First sort all the nodes in ascending order and store in an ArrayList 
         * i.e. use In-Order Traversal
         */
        List<Integer> inOrder = new ArrayList<Integer>();
        inOrderTraversal(root, inOrder);
        /**
         * Now to create a Balanced Binary Search Tree, we can use two pointer approach
         */
        return bstHelper(inOrder, 0, inOrder.size() - 1);
    }

    private TreeNode bstHelper(List<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = bstHelper(inOrder, start, mid - 1);
        root.right = bstHelper(inOrder, mid + 1, end);
        return root;
    }

    /**
     * In-Order Traversal - Left Node Right
     */
    private void inOrderTraversal(TreeNode node, List<Integer> inOrder) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, inOrder);
        inOrder.add(node.val);
        inOrderTraversal(node.right, inOrder);
    }
}
