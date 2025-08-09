class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        solveRecursion(0, n, nums, current, result); // TC: O(2 ^ N), SC: O(N)
        return result;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int n, int[] nums, List<Integer> current,
        List<List<Integer>> result) {
        // Base Case
        if (idx == n) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        // Recursion Case
        // we can opt to pick or skip
        // pick
        current.add(nums[idx]);
        solveRecursion(idx + 1, n, nums, current, result);
        // skip
        current.remove(current.size() - 1); // backtrack
        solveRecursion(idx + 1, n, nums, current, result);
    }
}
