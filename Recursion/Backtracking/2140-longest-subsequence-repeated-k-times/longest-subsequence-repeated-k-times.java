class Solution {
    String result = "";

    /**
     * Approach : Using Backtracking Approach
     *
     * TC: O(N * (N / K)!)
     * SC: O(N/K)
     */
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        // we need to filter out those characters whose frequency is less than k (unuseable characters)
        boolean[] canUse = new boolean[26];
        int[] reqdFreq = new int[26];
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freq[i] >= k) {
                canUse[i] = true;
                reqdFreq[i] = freq[i] / k;
            }
        }
        int maxLength = n / k;
        StringBuilder current = new StringBuilder();
        backtrack(s, k, current, canUse, reqdFreq, maxLength);
        return result;
    }

    private void backtrack(String s, int k, StringBuilder curr, boolean[] canUse,
        int[] requiredFreq, int maxLen) {
        if (curr.length() > maxLen) return;

        String currStr = curr.toString();
        if ((curr.length() > result.length() || 
             (curr.length() == result.length() && currStr.compareTo(result) > 0)) &&
            isSubsequence(s, currStr, k)) {
            result = currStr;
        }

        for (int i = 25; i >= 0; i--) { // from 'z' to 'a' for lexicographically larger result
            if (!canUse[i] || requiredFreq[i] == 0) continue;

            curr.append((char) (i + 'a'));
            requiredFreq[i]--;

            backtrack(s, k, curr, canUse, requiredFreq, maxLen);

            curr.deleteCharAt(curr.length() - 1);
            requiredFreq[i]++;
        }
    }

    // Check if seq * k is a subsequence of s
    private boolean isSubsequence(String s, String sub, int k) {
        int i = 0, j = 0, len = sub.length(), n = s.length();

        while (i < n && j < k * len) {
            if (s.charAt(i) == sub.charAt(j % len)) {
                j++;
            }
            i++;
        }

        return j == k * len;
    }
}
