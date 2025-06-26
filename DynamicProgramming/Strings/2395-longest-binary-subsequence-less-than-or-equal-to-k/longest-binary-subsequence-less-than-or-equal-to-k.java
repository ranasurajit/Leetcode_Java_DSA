class Solution {
    /**
     * Approach IV : Using Greedy Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(1)
     *
     * Accepted (153 / 153 testcases passed)
     *
     * Intuition: No point of calculating for bit index > k
     */
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (s.charAt(i) == '0') {
                zeroes++;
            }
        }
        int value = 0;
        int pow = 1;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            char ch = s.charAt(i);
            if (ch == '1') {
                if (value + pow > k) {
                    continue;
                }
                value += pow;
                ones++;
            }
            pow = pow << 1;
            if (pow > k) {
                break;
            }
        }
        return ones + zeroes;
    }

    /**
     * Approach III : Using Memoization Approach
     *
     * TC: O(N x N x K)
     * SC: O(N x N x K + N)
     *
     * Time Limit Exceeded (52 / 153 testcases passed)
     *
     * DP solution will not work as N x N x K ~ (10 ^ 3 x 10 ^ 3 x 10 ^ 9 = 10 ^ 15)
     * so we can go with Greedy Approach
     */
    public int longestSubsequenceMemoization(String s, int k) {
        int n = s.length();
        // we have 3 changing parameters idx, count, value
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return solveMemoization(0, n, s, 0, 0, (long) k, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, String s, int count, int value, long k,
        Map<String, Integer> memo) {
        // Base Case
        if (idx == n) {
            return count;
        }
        String key = idx + "|" + count + "|" + value;
        // Memoization Check
        if (value <= k && memo.containsKey(key)) {
            return memo.get(key);
        }
        // Recursion Calls
        // we can take or skip the character at index 'idx'
        int newValue = (value << 1 | (s.charAt(idx) - '0'));
        int take = 0;
        int skip = 0;
        if (newValue <= k) { // TC: O(N)
            // we can take or skip
            // take
            take = solveMemoization(idx + 1, n, s, count + 1, newValue, k, memo); // explore
            // skip
            skip = solveMemoization(idx + 1, n, s, count, value, k, memo); // explore
        } else {
            // we cannot take
            skip = solveMemoization(idx + 1, n, s, count, value, k, memo); // explore
        }
        int result = Math.max(take, skip);
        memo.put(key, result);
        return result;
    }

    /**
     * Approach II : Using Optimal Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (52 / 153 testcases passed)
     */
    public int longestSubsequenceOptimalRecursion(String s, int k) {
        int n = s.length();
        return solveRecursion(0, n, s, 0, 0L, (long) k);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, String s, int count, long value, long k) {
        // Base Case
        if (idx == n) {
            return count;
        }
        // Recursion Calls
        // we can take or skip the character at index 'idx'
        long newValue = (value << 1 | (s.charAt(idx) - '0'));
        int take = 0;
        int skip = 0;
        if (newValue <= k) { // TC: O(N)
            // we can take or skip
            // take
            take = solveRecursion(idx + 1, n, s, count + 1, newValue, k); // explore
            // skip
            skip = solveRecursion(idx + 1, n, s, count, value, k); // explore
        } else {
            // we cannot take
            skip = solveRecursion(idx + 1, n, s, count, value, k); // explore
        }
        return Math.max(take, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N x 2 ^ N + N) ~ O(N x 2 ^ N)
     * SC: O(2 ^ N + N) ~ O(2 ^ N)
     *
     * Time Limit Exceeded (52 / 153 testcases passed)
     */
    public int longestSubsequenceRecursion(String s, int k) {
        int n = s.length();
        List<String> result = new ArrayList<String>(); // SC: O(2 ^ N)
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        solveRecursion(0, n, s, sb, result, (long) k);
        int maxLength = 0;
        for (String str : result) { // TC: O(N)
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int n, String s, StringBuilder sb, List<String> result, long k) {
        // Base Case
        if (idx == n) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }
        // Recursion Calls
        // we can take or skip the character at index 'idx'
        if (sb.length() == 0 || isLessThanK(sb.toString() + s.charAt(idx), k)) { // TC: O(N)
            // we can take or skip
            // take
            sb.append(s.charAt(idx)); // modify
            solveRecursion(idx + 1, n, s, sb, result, k); // explore
            sb.setLength(sb.length() - 1); // backtrack
            // skip
            solveRecursion(idx + 1, n, s, sb, result, k); // explore
        } else {
            // we cannot take
            solveRecursion(idx + 1, n, s, sb, result, k); // explore
        }
    }

    /**
     * Using Simulation + Math Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private boolean isLessThanK(String binaryStr, long k) {
        long num = 0;
        int n = binaryStr.length();
        int pow = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            num += (long) Math.pow(2, pow) * (long) (binaryStr.charAt(i) - '0');
            pow++;
        }
        return num <= k;
    }
}
