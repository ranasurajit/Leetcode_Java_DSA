class Solution {
    /**
     * Without using Stack
     * TC: O(N)
     * SC: O(1)
     */
    public int minSwaps(String s) {
        int n = s.length();
        int open = 0; // count of open brackets
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (open > 0 && ch == ']') {
                open--; // negating balanced brackets
            } else {
                if (ch == '[') {
                    open++;
                }
            }
        }
        /*
         * For any best swaps made creates a pair of
         * balanced brackets so we need number of swaps 
         * = (num open brackets + 1) / 2 to make all brackets 
         * balanced
         */
        return (open + 1) / 2;
    }
}
