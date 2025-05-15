class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     *
     * Accepted (382 / 382 testcases passed)
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        Map<String, List<Integer>> memo = new HashMap<String, List<Integer>>(); // SC: O(N)
        List<Integer> indices = solveMemoization(0, -1, n, groups, memo); // TC: O(N), SC: O(N)
        List<String> result = new ArrayList<String>();
        for (Integer it : indices) { // TC: O(N)
            result.add(words[it]);
        }
        return result;
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private List<Integer> solveMemoization(int idx, int prevGroup, int n, int[] groups,
        Map<String, List<Integer>> memo) {
        // Base Case
        if (idx == n) {
            return new ArrayList<Integer>();
        }
        String key = idx + "|" + prevGroup;
        // Memoization Check
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // Recursion Calls
        // we can take or not take
        // not take
        List<Integer> skip = solveMemoization(idx + 1, prevGroup, n, groups, memo);
        List<Integer> take = new ArrayList<Integer>();
        if (prevGroup == -1 || prevGroup != groups[idx]) {
            // take
            take.add(idx);
            take.addAll(solveMemoization(idx + 1, groups[idx], n, groups, memo));
        }
        List<Integer> result = take.size() > skip.size() ? take : skip;
        memo.put(key, result);
        return result; 
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N + N) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (278 / 382 testcases passed)
     */
    public List<String> getLongestSubsequenceRecursion(String[] words, int[] groups) {
        int n = words.length;
        List<Integer> indices = solveRecursion(0, -1, n, groups); // TC: O(2 ^ N), SC: O(N)
        List<String> result = new ArrayList<String>();
        for (Integer it : indices) { // TC: O(N)
            result.add(words[it]);
        }
        return result;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private List<Integer> solveRecursion(int idx, int prevGroup, int n, int[] groups) {
        // Base Case
        if (idx == n) {
            return new ArrayList<Integer>();
        }
        // Recursion Calls
        // we can take or not take
        // not take
        List<Integer> skip = solveRecursion(idx + 1, prevGroup, n, groups);
        List<Integer> take = new ArrayList<Integer>();
        if (prevGroup == -1 || prevGroup != groups[idx]) {
            // take
            take.add(idx);
            take.addAll(solveRecursion(idx + 1, groups[idx], n, groups));
        }
        return take.size() > skip.size() ? take : skip;
    }
}
