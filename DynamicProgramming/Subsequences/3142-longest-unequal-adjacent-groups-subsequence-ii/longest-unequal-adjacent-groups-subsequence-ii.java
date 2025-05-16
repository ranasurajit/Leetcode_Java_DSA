class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(K x N ^ 2)
     * SC: O(N ^ 2 + N)
     *
     * where K = MaxLength(words[i])
     *
     * Accepted (441 / 441 testcases passed)
     */
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        Map<Integer, Map<Integer, List<Integer>>> memo =
            new HashMap<Integer, Map<Integer, List<Integer>>>(); // SC: O(N x N)
        List<Integer> indices = 
            solveMemoization(0, -1, n, words, groups, memo); // TC: O(K x N x N), SC: O(N)
        List<String> result = new ArrayList<String>();
        for (Integer it : indices) { // TC: O(N)
            result.add(words[it]);
        }
        return result;
    }

    /**
     * Using Memoization
     *
     * TC: O(K x N x N)
     * SC: O(N)
     */
    private List<Integer> solveMemoization(int idx, int prevIdx, int n, 
        String[] words, int[] groups, Map<Integer, Map<Integer, List<Integer>>> memo) {
        // Base Case
        if (idx == n) {
            return new ArrayList<Integer>();
        }
        // Memoization Check
        if (memo.containsKey(idx) && memo.get(idx).containsKey(prevIdx)) {
            return memo.get(idx).get(prevIdx);
        }
        // Recursion Calls
        // not take
        List<Integer> skip = solveMemoization(idx + 1, prevIdx, n, words, groups, memo);
        // take
        List<Integer> take = new ArrayList<Integer>();
        if (prevIdx == -1 || 
            (groups[prevIdx] != groups[idx] && 
             hasHammingDistance(words[prevIdx], words[idx]))) { // TC: O(K), SC: O(1)
            take.add(idx);
            take.addAll(solveMemoization(idx + 1, idx, n, words, groups, memo));
        }
        List<Integer> maxList = take.size() > skip.size() ? take : skip;
        memo.computeIfAbsent(idx, k -> new HashMap<Integer, List<Integer>>()).put(prevIdx, maxList);
        return maxList;
    }

    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(K x 2 ^ N + N ^ 2) ~ O(K x 2 ^ N)
     * SC: O(N)
     * 
     * where K = MaxLength(words[i])
     *
     * Time Limit Exceeded (435 / 441 testcases passed)
     */
    public List<String> getWordsInLongestSubsequenceRecursion(String[] words, int[] groups) {
        int n = groups.length;
        List<Integer> indices = solveRecursion(0, -1, n, words, groups); // TC: O(K x 2 ^ N), SC: O(N)
        List<String> result = new ArrayList<String>();
        for (Integer it : indices) { // TC: O(N)
            result.add(words[it]);
        }
        return result;
    }

    /**
     * Using Recursion
     *
     * TC: O(K x 2 ^ N)
     * SC: O(N)
     */
    private List<Integer> solveRecursion(int idx, int prevIdx, int n, String[] words, int[] groups) {
        // Base Case
        if (idx == n) {
            return new ArrayList<Integer>();
        }
        // Recursion Calls
        // not take
        List<Integer> skip = solveRecursion(idx + 1, prevIdx, n, words, groups);
        // take
        List<Integer> take = new ArrayList<Integer>();
        if (prevIdx == -1 || 
            (groups[prevIdx] != groups[idx] && 
             hasHammingDistance(words[prevIdx], words[idx]))) { // TC: O(K), SC: O(1)
            take.add(idx);
            take.addAll(solveRecursion(idx + 1, idx, n, words, groups));
        }
        return take.size() > skip.size() ? take : skip;
    }

    /**
     * Using Simulation
     *
     * TC: O(K)
     * SC: O(1)
     */
    private boolean hasHammingDistance(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int n = a.length();
        int p = 0; // pointer at String 'a'
        int q = 0; // pointer at String 'b'
        int diff = 0;
        while (p < n && q < n) { // TC: O(N)
            if (a.charAt(p) != b.charAt(q)) {
                diff++;
            }
            p++;
            q++;
        }
        return diff == 1;
    }
}
