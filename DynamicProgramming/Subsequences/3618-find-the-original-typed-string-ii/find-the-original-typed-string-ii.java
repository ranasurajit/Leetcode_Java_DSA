class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private int[][] memo;
    private int[] groups;
    private int k;

    public int possibleStringCount(String word, int k) {
        List<Integer> groups = getConsecutiveLetters(word);
        final int totalCombinations =
            (int) groups.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b % MOD);
        if (k <= groups.size())
            return totalCombinations;

        // dp[j] := the number of ways to form strings of length j using
        // groups[0..i]
        int[] dp = new int[k];
        dp[0] = 1; // Base case: empty string

        for (int i = 0; i < groups.size(); ++i) {
            int[] newDp = new int[k];
            int windowSum = 0;
            int group = groups.get(i);
            for (int j = i; j < k; ++j) {
                newDp[j] = (newDp[j] + windowSum) % MOD;
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= group)
                windowSum = (windowSum - dp[j - group] + MOD) % MOD;
            }
            dp = newDp;
        }
        final int invalidCombinations = Arrays.stream(dp).reduce(0, (a, b) -> (a + b) % MOD);
        return (totalCombinations - invalidCombinations + MOD) % MOD;
    }

    // Returns consecutive identical letters in the input string.
    // e.g. "aabbbc" -> [2, 3, 1].
    private List<Integer> getConsecutiveLetters(final String word) {
        List<Integer> groups = new ArrayList<>();
        int group = 1;
        for (int i = 1; i < word.length(); ++i)
        if (word.charAt(i) == word.charAt(i - 1)) {
            ++group;
        } else {
            groups.add(group);
            group = 1;
        }
        groups.add(group);
        return groups;
    }

    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N x N x L)
     * SC: O(N) + O(N) + O(N)
     *
     * Memory Limit Exceeded (817 / 846 testcases passed)
     */
    public int possibleStringCountTabulation(String word, int k) {
        int[] groups = compress(word);
        int n = groups.length;
        int maxLen = 0;
        for (int g : groups) maxLen += g;

        int[][] dp = new int[n + 1][maxLen + 1];
        dp[0][0] = 1; // base case

        for (int i = 0; i < n; i++) {
            int g = groups[i];

            // prefix sum for dp[i][..]
            int[] prefix = new int[maxLen + 2];
            for (int len = 0; len <= maxLen; len++) {
                prefix[len + 1] = (prefix[len] + dp[i][len]) % MOD;
            }

            for (int len = 0; len <= maxLen; len++) {
                // We want to pick x chars from current group (1 ≤ x ≤ g)
                // So we transfer from dp[i][len - x] to dp[i+1][len]
                if (len - g >= 0) {
                    dp[i + 1][len] = (prefix[len] - prefix[len - g] + MOD) % MOD;
                } else {
                    dp[i + 1][len] = prefix[len]; // use all up to len-1
                }
            }
        }

        // Final answer = total ways to form original strings with length ≥ k
        int ans = 0;
        for (int len = k; len <= maxLen; len++) {
            ans = (ans + dp[n][len]) % MOD;
        }
        return ans;
    }

    private int[] compress(String s) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N x L)
     * SC: O(N) + O(N) + O(N)
     *
     * Time Limit Exceeded (817 / 846 testcases passed)
     */
    public int possibleStringCountMemoizationII(String word, int k) {
        this.k = k;
        this.groups = compress(word);
        int n = groups.length;
        int maxLen = 0;
        for (int g : groups) maxLen += g;

        memo = new int[n + 1][maxLen + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    // dfs from group 'i' with total chars picked = 'sum'
    private int dfs(int i, int sum) {
        if (i == groups.length) {
            return sum >= k ? 1 : 0;
        }

        if (memo[i][sum] != -1) return memo[i][sum];

        long res = 0;
        for (int pick = 1; pick <= groups[i]; pick++) {
            res = (res + dfs(i + 1, sum + pick)) % MOD;
        }

        return memo[i][sum] = (int) res;
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N x L)
     * SC: O(N) + O(N) + O(N)
     *
     * Time Limit Exceeded (658 / 846 testcases passed)
     */
    public int possibleStringCountMemoization(String word, int k) {
        int n = word.length();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        Set<String> set = new HashSet<String>(); // SC: O(N)
        Map<String, Integer> memo = new HashMap<String, Integer>(); // SC: O(N)
        return solveMemoization(0, -1, n, sb, word, k, set, memo);
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x N x L)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int prevIndex, int n, StringBuilder sb, 
        String word, int k, Set<String> set, Map<String, Integer> memo) {
        // Base Case
        if (idx == n) {
            if (sb.length() >= k && !set.contains(sb.toString())) {
                set.add(sb.toString());
                return 1;
            }
            return 0;
        }
        String key = idx + "-" + prevIndex + "-" + sb.toString();
        // Memoization Check
        if (memo.containsKey(key)) {
            // already counted so return 0
            return memo.get(key);
        }
        // Recursion Calls
        int pick = 0;
        int skip = 0;
        char ch = word.charAt(idx);
        if ((ch - 'a') != prevIndex) {
            // we must take it
            sb.append(ch); // modify
            pick = solveMemoization(idx + 1, (ch - 'a'), n, sb, word, k, set, memo); // explore
            sb.setLength(sb.length() - 1); // backtrack
        } else {
            // we have options to pick or skip
            sb.append(ch); // modify
            pick = solveMemoization(idx + 1, (ch - 'a'), n, sb, word, k, set, memo) % MOD; // explore
            sb.setLength(sb.length() - 1); // backtrack
            skip = solveMemoization(idx + 1, prevIndex, n, sb, word, k, set, memo) % MOD; // explore
        }
        int result = (pick + skip) % MOD;
        memo.put(key, result);
        return result;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N) + O(N) + O(N)
     *
     * Time Limit Exceeded (658 / 846 testcases passed)
     */
    public int possibleStringCountRecursion(String word, int k) {
        int n = word.length();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        Set<String> set = new HashSet<String>(); // SC: O(N)
        return solveRecursion(0, -1, n, sb, word, k, set);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int prevIndex, int n, StringBuilder sb, 
        String word, int k, Set<String> set) {
        // Base Case
        if (idx == n) {
            if (sb.length() >= k && !set.contains(sb.toString())) {
                set.add(sb.toString());
                return 1;
            }
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int skip = 0;
        char ch = word.charAt(idx);
        if ((ch - 'a') != prevIndex) {
            // we must take it
            sb.append(ch); // modify
            pick = solveRecursion(idx + 1, (ch - 'a'), n, sb, word, k, set); // explore
            sb.setLength(sb.length() - 1); // backtrack
        } else {
            // we have options to pick or skip
            sb.append(ch); // modify
            pick = solveRecursion(idx + 1, (ch - 'a'), n, sb, word, k, set) % MOD; // explore
            sb.setLength(sb.length() - 1); // backtrack
            skip = solveRecursion(idx + 1, prevIndex, n, sb, word, k, set) % MOD; // explore
        }
        return (pick + skip) % MOD;
    }
}
