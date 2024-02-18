class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        helper(nums, 0, result, current);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        // take 
        current.add(nums[index]);
        helper(nums, index + 1, result, current);
        // not take
        // backtrack
        current.remove(current.size() - 1);
        helper(nums, index + 1, result, current);
    }
}
