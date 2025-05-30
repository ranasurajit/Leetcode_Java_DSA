class Solution {
    /**
     * Approach I : Using Recursion + Backtracking (Knapsack Recursion Template) Approach
     *
     * TC: O(2 ^ N)
     * SC: O(2 ^ N + 2 x N) ~ O(2 ^ N)
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>(); // SC: O(2 ^ N)
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        solveRecursion(0, -1, n, nums, current, result); // TC: O(2 ^ N), SC: O(N)
        return new ArrayList<List<Integer>>(result);
    }

    /**
     * Using Recursion + Backtracking Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int index, int prevIndex, int n, int[] nums, List<Integer> current,
        Set<List<Integer>> result) {
        // Base Case
        if (index == n) {
            if (current.size() > 1) {
                result.add(new ArrayList<Integer>(current));
            }
            return;
        }
        // we have options to take or skip
        // skip
        solveRecursion(index + 1, prevIndex, n, nums, current, result);
        // take
        if (prevIndex == -1 || nums[index] >= nums[prevIndex]) {
            // modify
            current.add(nums[index]);
            // explore
            solveRecursion(index + 1, index, n, nums, current, result);
            // backtrack
            current.remove(current.size() - 1);
        }
    }
}
