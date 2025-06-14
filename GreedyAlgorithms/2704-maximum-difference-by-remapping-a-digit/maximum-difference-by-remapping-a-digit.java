class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int minMaxDifference(int num) {
        char[] maxNumChars = String.valueOf(num).toCharArray(); // SC: O(N)
        char[] minNumChars = String.valueOf(num).toCharArray(); // SC: O(N)
        int n = maxNumChars.length;
        char replaceChar = '0';
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (maxNumChars[i] != '9') {
                replaceChar = maxNumChars[i];
                break;
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (maxNumChars[i] == replaceChar) {
                maxNumChars[i] = '9';
            }
        }
        replaceChar = minNumChars[0];
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (minNumChars[i] == replaceChar) {
                minNumChars[i] = '0';
            }
        }
        return Integer.valueOf(String.valueOf(maxNumChars)) - Integer.valueOf(String.valueOf(minNumChars));
    }
}
