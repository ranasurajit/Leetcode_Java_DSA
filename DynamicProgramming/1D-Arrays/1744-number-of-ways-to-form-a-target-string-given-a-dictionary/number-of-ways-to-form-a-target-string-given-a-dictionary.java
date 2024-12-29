class Solution {
    private int[][] charFreq;
    private int MOD = 1000000007;
    private int n, tLen, wordLen;
    int[][] dp;

    /**
     * Using Recursion + Memoization - Dp (Top-Down approach)
     *
     * TC: O(M x N)
     * SC: O(M x N)
     * where M = length of target and N = length of a word in words
     */
    public int numWays(String[] words, String target) {
        n = words.length;
        tLen = target.length();
        wordLen = words[0].length();

        // creating character frequency of each words in array 'words'
        charFreq = new int[wordLen][26];
        for (String word : words) {
            for (int i = 0; i < wordLen; i++) {
                charFreq[i][word.charAt(i) - 'a']++;
            }
        }
        // initializing dp for memoization
        dp = new int[wordLen][tLen];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return countWays(words, target, 0, 0);
    }

    private int countWays(String[] words, String target, int sPos, int tPos) {
        // Base case
        if (tPos == tLen) {
            return sPos <= wordLen ? 1 : 0;
        }
        if (sPos >= wordLen || (wordLen - sPos) < tLen - tPos) {
            return 0;
        }
        if (dp[sPos][tPos] != -1) {
            return dp[sPos][tPos];
        }
        char current = target.charAt(tPos);
        long notPick = countWays(words, target, sPos + 1, tPos) % MOD;
        long pick = countWays(words, target, sPos + 1, tPos + 1) % MOD;
        long totalWays = (notPick + pick * (long) charFreq[sPos][current - 'a']) % MOD;
        dp[sPos][tPos] = (int) totalWays;
        return dp[sPos][tPos];
    }
}
