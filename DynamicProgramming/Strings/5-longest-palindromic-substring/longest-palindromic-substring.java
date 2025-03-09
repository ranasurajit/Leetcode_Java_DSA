class Solution {
    /**
     * Approach II: Using Memoization Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        int startIndex = 0;
        // Initialization of memory
        int[][] memo = new int[n + 1][n + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                // isPalindromeMemoization has ammortized complexity of TC: O(1)
                if (isPalindromeMemoization(i, j, s, memo) && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private boolean isPalindromeMemoization(int i, int j, String s, int[][] memo) {
        // Base Case
        if (i >= j) {
            return true;
        }
        // Memoization Check
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        // Recursion Calls
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = isPalindromeMemoization(i + 1, j - 1, s, memo) ? 1 : 0;
        } else {
            memo[i][j] = 0;
        }
        return memo[i][j] == 1;
    }

    /**
     * Approach I: Using Recursion Approach
     *
     * TC: O(N ^ 3)
     * SC: O(N)
     */
    public String longestPalindromeApproachI(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        int startIndex = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                if (isPalindromeRecursion(i, j, s) && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private boolean isPalindromeRecursion(int i, int j, String s) {
        // Base Case
        if (i >= j) {
            return true;
        }
        // Recursion Calls
        if (s.charAt(i) == s.charAt(j)) {
            return isPalindromeRecursion(i + 1, j - 1, s);
        } else {
            return false;
        }
    }
}
