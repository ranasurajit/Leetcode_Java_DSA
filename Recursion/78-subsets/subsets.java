class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> uniques = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        solveRecursion(0, nums, n, current, uniques);
        return uniques;
    }

    /**
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int[] arr, int n, List<Integer> current,
        List<List<Integer>> uniques) {
        // Base Case
        if (idx == n) {
            uniques.add(new ArrayList<Integer>(current)); // TC: O(N)
            return;
        }
        // Recursion Calls
        // not take
        solveRecursion(idx + 1, arr, n, current, uniques);
        // take
        current.add(arr[idx]);
        solveRecursion(idx + 1, arr, n, current, uniques);
        // backtrack to explore all other possibilities
        current.remove(current.size() - 1);
    }
}
