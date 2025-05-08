class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        solveRecursion(0, n, sb, result); // TC: O(2 ^ N), SC: O(N)
        return result;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static void solveRecursion(int idx, int n, StringBuilder sb, List<String> result) {
        // Base Case
        if (idx == n) {
            result.add(sb.toString());
            return;
        }
        // Recursion Calls
        // take 1 or 0 (condition based)
        // take 1
        sb.append('1');
        solveRecursion(idx + 1, n, sb, result);
        sb.setLength(sb.length() - 1); // backtrack
        // take 1
        if (sb.length() == 0 || sb.charAt(idx - 1) != '0') {
            sb.append('0');
            solveRecursion(idx + 1, n, sb, result);
            sb.setLength(sb.length() - 1); // backtrack
        }
    }
}
