class Solution {
    /**
     * Approach II : Using String Simulation Approach
     *
     * TC: O(K x K)
     * SC: O(K)
     *
     * Accepted (502 / 502 testcases passed)
     */
    public char kthCharacter(int k) {
        String s = "a";
        while (s.length() < k) {
            int size = s.length();
            for (int i = 0; i < size; i++) {
                int offset = ((s.charAt(i) - 'a') + 1) % 26;
                char ch = (char) ('a' + offset);
                s += ch;
            }
        }
        return s.charAt(k - 1);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(K x log(K) Base 2)
     * SC: O(K)
     *
     * Memory Limit Exceeded (28 / 502 testcases passed)
     */
    public char kthCharacterRecursion(int k) {
        StringBuilder sb = new StringBuilder("a");
        solveRecursion(sb, k);
        return sb.charAt(k - 1);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(K x log(K) Base 2)
     * SC: O(K)
     */
    private void solveRecursion(StringBuilder sb, int k) {
        // Base Case
        if (k == 0) {
            return;
        }
        // Recursion Calls
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) { // TC: O(log(K) Base 2)
            int offset = ((sb.charAt(i) - 'a') + 1) % 26;
            newStr.append((char) ('a' + offset));
        }
        sb.append(newStr); // modify
        solveRecursion(sb, k - 1); // explore
    }
}
