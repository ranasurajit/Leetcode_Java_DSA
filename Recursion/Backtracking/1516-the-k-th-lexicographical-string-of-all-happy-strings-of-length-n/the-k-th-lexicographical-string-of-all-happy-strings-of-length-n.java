class Solution {
    /**
     * Using Backtracking Approach
     *
     * TC : O(N x 3 x 2 ^ (N - 1)) ~ O(N * 2 ^ N)
     * SC: O(N * 2 ^ N)
     */
    public String getHappyString(int n, int k) {
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
