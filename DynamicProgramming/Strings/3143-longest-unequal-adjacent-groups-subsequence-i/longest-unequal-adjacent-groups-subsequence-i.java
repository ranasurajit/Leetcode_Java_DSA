class Solution {
    /**
     * Approach III : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Accepted (382 / 382 testcases passed)
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i == 0 || groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        return result;
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     *
     * Accepted (382 / 382 testcases passed)
     */
    public List<String> getLongestSubsequenceMemoization(String[] words, int[] groups) {
        int n = words.length;
        Map<Integer, Map<Integer, List<Integer>>> memo = 
            new HashMap<Integer, Map<Integer, List<Integer>>>(); // SC: O(N)
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
        Map<Integer, Map<Integer, List<Integer>>> memo) {
        // Base Case
        if (idx == n) {
            return new ArrayList<Integer>();
        }
        // Memoization Check
        if (memo.containsKey(idx) && memo.get(idx).containsKey(prevGroup)) {
            return memo.get(idx).get(prevGroup);
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
        memo.computeIfAbsent(idx, k -> new HashMap<Integer, List<Integer>>()).put(prevGroup, result);
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
