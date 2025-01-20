class Solution {
    /**
     * Using Recursion + Backtracking Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(2 x N) ~ O(N)
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        backtrack(0, nums, n, current, result); // TC: O(2 ^ N), SC: O(N)
        return result;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     * 
     * @param index
     * @param nums
     * @param n
     * @param current
     * @param result
     */
    private void backtrack(int index, int[] nums, int n,
            List<Integer> current, List<List<Integer>> result) {
        if (current.size() > 1) {
            result.add(new ArrayList<Integer>(current));
        }
        /**
         * Created set to make sure duplicate elements are not included in the
         * same recursion call instance
         */
        Set<Integer> set = new HashSet<Integer>();
        for (int i = index; i < n; i++) {
            // include
            if ((current.isEmpty() || nums[i] >= current.get(current.size() - 1)) &&
                    !set.contains(nums[i])) {
                // pick
                current.add(nums[i]);
                backtrack(i + 1, nums, n, current, result);
                current.remove(current.size() - 1); // backtrack (undo)
                set.add(nums[i]);
            }
        }
    }
}
