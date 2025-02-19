class Solution {
    /**
     * Approach II - Using Backtracking Approach - Optimal Approach
     *
     * TC : O(N x 3 x 2 ^ (N - 1)) ~ O(N * 2 ^ N)
     * SC: O(N)
     */
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] count = { 0 };
        String[] result = { "" };
        solveOptimal(n, sb, count, result, k);
        return result[0];
    }

    private void solveOptimal(int n, StringBuilder sb, int[] count, 
        String[] result, int k) {
        // Base case
        if (sb.length() == n) {
            count[0]++;
            if (count[0] == k) {
                result[0] = sb.toString();
            }
            return;
        }
        // explore all possibilities
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                continue;
            }
            sb.append(ch); // do
            solveOptimal(n, sb, count, result, k); // explore
            sb.setLength(sb.length() - 1); // undo - backtrack
        }
    }

    /**
     * Approach I - Using Backtracking Approach
     *
     * TC : O(N x 3 x 2 ^ (N - 1)) ~ O(N * 2 ^ N)
     * SC: O(N * 2 ^ N)
     */
    public String getHappyStringApproachII(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<String>();
        solve(n, sb, result);
        if (result.size() < k) {
            return "";
        }
        return result.get(k - 1);
    }

    private void solve(int n, StringBuilder sb, List<String> result) {
        // Base case
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        // explore all possibilities
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                continue;
            }
            sb.append(ch); // do
            solve(n, sb, result); // explore
            sb.setLength(sb.length() - 1); // undo - backtrack
        }
    }
}
