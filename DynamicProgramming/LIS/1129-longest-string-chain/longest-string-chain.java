class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x log(N)) + O(L x N x N) + O(N x N) ~ O(L x N x N)
     * SC: O(N x N) + O(N)
     * 
     * - O(N x N) - memoization memory
     * - O(N) - recursion stack
     * where L = Max(words)
     *
     * Accepted (86 / 86 testcases passed)
     */
    public int longestStrChain(String[] words) {
        int n = words.length;
        // Sorting is needed so that we can form the chain
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // TC: O(N x log(N))
        int[][] memo = new int[n + 1][n + 1]; // SC: O(N x N)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(N)
        }
        return solveMemoization(0, -1, n, words, memo); // TC: O(L x N x N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x N x L)
     * SC: O(N)
     *
     * where L = Max(words)
     */
    private int solveMemoization(int idx, int prevIdx, int n, String[] words, int[][] memo) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][prevIdx + 1] != -1) {
            // coordinated shifted for prevIdx
            return memo[idx][prevIdx + 1];
        }
        // Recursion Calls
        // we can opt to pick or skip
        int skip = solveMemoization(idx + 1, prevIdx, n, words, memo);
        int pick = 0;
        // we can pick if any only if prevIdx = -1 or words[prevIdx] is a subsequence of words[idx]
        if (prevIdx == -1 || isPredecessor(words[idx], words[prevIdx])) { // TC: O(L)
            pick = 1 + solveMemoization(idx + 1, idx, n, words, memo);
        }
        return memo[idx][prevIdx + 1] = Math.max(pick, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(L x 2 ^ N) + O(N x log(N)) ~ O(L x 2 ^ N)
     * SC: O(N)
     *
     * - O(N) - recursion stack
     * where L = Max(words)
     *
     * Time Limit Exceeded (78 / 86 testcases passed)
     */
    public int longestStrChainRecursion(String[] words) {
        int n = words.length;
        // Sorting is needed so that we can form the chain
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // TC: O(N x log(N))
        return solveRecursion(0, -1, n, words); // TC: O(L x 2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(L x 2 ^ N)
     * SC: O(N)
     *
     * where L = Max(words)
     */
    private int solveRecursion(int idx, int prevIdx, int n, String[] words) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        // Recursion Calls
        // we can opt to pick or skip
        int skip = solveRecursion(idx + 1, prevIdx, n, words);
        int pick = 0;
        // we can pick if any only if prevIdx = -1 or words[prevIdx] is a subsequence of words[idx]
        if (prevIdx == -1 || isPredecessor(words[idx], words[prevIdx])) { // TC: O(L)
            pick = 1 + solveRecursion(idx + 1, idx, n, words);
        }
        return Math.max(pick, skip);
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(L), where L = Max(words)
     * SC: O(1)
     */
    private boolean isPredecessor(String word, String part) {
        int m = word.length();
        int n = part.length();
        int p = 0; // pointer at start of String 'word'
        int q = 0; // pointer at start of String 'part'
        if (n + 1 != m) {
            return false;
        }
        boolean skipped = false;
        while (p < m && q < n) {
            if (word.charAt(p) == part.charAt(q)) {
                p++;
                q++;
            } else {
                if (skipped) {
                    // already skipped once
                    return false;
                }
                skipped = true;
                p++;
            }
        }
        return true;
    }
}
