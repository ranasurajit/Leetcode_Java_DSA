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
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public int minimumOperations(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // SC: O(N)
        queue.offer(root);
        int minSwaps = 0;
        int level = 0;
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            ArrayList<Integer> listNodes = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (level > 0) {
                    listNodes.add(node.val);
                }
            }
            if (listNodes.size() > 0) {
                minSwaps += getMinSwapsToSort(listNodes); // TC: O(N x log(N)), SC: O(N)
            }
            level++;
        }
        return minSwaps;
    }

    /**
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    private int getMinSwapsToSort(ArrayList<Integer> list) {
        int n = list.size();
        int minSwaps = 0;
        // HashMap to store <value, index> - SC: O(N)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            hm.put(list.get(i), i);
        }
        // Get the sorted values of list to compare the expected positions of values
        ArrayList<Integer> sorted = new ArrayList<Integer>(list); // SC: O(N)
        Collections.sort(sorted); // TC: O(N x log(N))
        int iteration = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (visited[i] || hm.get(sorted.get(i)) == i) {
                continue;
            }
            int cycles = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = hm.get(sorted.get(j));
                cycles++;
            }
            minSwaps += cycles - 1;
        }
        return minSwaps;
    }
}
