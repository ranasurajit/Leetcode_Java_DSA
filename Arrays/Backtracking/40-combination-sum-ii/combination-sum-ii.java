class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(0, candidates, target, combinations, current);
        return combinations;
    }

    private void helper(int index, int[] candidates, int target, 
        List<List<Integer>> combinations, List<Integer> current) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // to ignore duplications in the result;
                continue;
            }
            current.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], combinations, current);
            // backtrack to try all other combinations
            current.remove(current.size() - 1);
        }
    }
}
