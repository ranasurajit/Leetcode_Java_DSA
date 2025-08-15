class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     */
    public String countAndSay(int n) {
        return solveRecursion(n);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N x N)
     * SC: O(N)
     */
    private String solveRecursion(int n) {
        // Base Case
        if (n == 1) {
            return "1";
        }
        // Recursion Calls
        String current = solveRecursion(n - 1);
        StringBuilder sb = new StringBuilder();
        int m = current.length();
        int idx = 0;
        while (idx < m) { // TC: O(N) in worst case
            int count = 1;
            while (idx < m - 1 && current.charAt(idx) == current.charAt(idx + 1)) {
                count++;
                idx++;
            }
            sb.append(count).append(current.charAt(idx));
            idx++;
        }
        return sb.toString();
    }
}
