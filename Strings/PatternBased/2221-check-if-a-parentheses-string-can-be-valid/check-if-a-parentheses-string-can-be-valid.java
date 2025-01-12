class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) == 1) {
            // odd length strings are invalid
            return false;
        }
        // from left to right checking overbalance of ')' parenthesis
        int open = 0;
        int close = 0;
        int wildcard = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (locked.charAt(i) == '0') {
                wildcard++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (wildcard + open < close) {
                return false;
            }
        }
        // from right to left checking overbalance of '(' parenthesis
        open = 0;
        close = 0;
        wildcard = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            if (locked.charAt(i) == '0') {
                wildcard++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (wildcard + close < open) {
                return false;
            }
        }
        return true;
    }
}
