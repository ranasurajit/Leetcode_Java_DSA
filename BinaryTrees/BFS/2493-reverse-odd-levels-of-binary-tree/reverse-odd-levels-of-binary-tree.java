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
     * TC: O(N + K) ~ O(N)
     * SC: O(N)
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            List<TreeNode> swapList = new ArrayList<TreeNode>(); // SC: O(K)
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (level % 2 != 0) {
                    // at odd level add it to a List to swap later
                    swapList.add(node);
                }
            }
            if (level % 2 != 0) {
                reverseListValues(swapList); // TC: O(K)
            }
            level++;
        }
        return root;
    }

    /**
     * TC: O(K / 2) ~ O(K), where K is the size of swapList
     * SC: O(1)
     */
    private void reverseListValues(List<TreeNode> swapList) {
        int start = 0;
        int end = swapList.size() - 1;
        while (start < end) {
            int temp = swapList.get(end).val;
            swapList.get(end).val = swapList.get(start).val;
            swapList.get(start).val = temp;
            start++;
            end--;
        }
    }
}
