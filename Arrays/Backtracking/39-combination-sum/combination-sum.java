class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        findCombinations(0, 0, candidates, target, current, result);
        return result;
    }

    private void findCombinations(int index, int sum, int[] candidates, 
        int target, List<Integer> current, List<List<Integer>> result) {
        // Base case
        if (index == candidates.length) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(current));
            }
            return;
        }
        // pick (any number of times)
        if (sum + candidates[index] <= target) {
            current.add(candidates[index]);
            findCombinations(index, sum + candidates[index], candidates, target, current, result);
            // backtrack
            current.remove(current.size() - 1);
        }
        // not pick
        findCombinations(index + 1, sum, candidates, target, current, result);
    }
}
