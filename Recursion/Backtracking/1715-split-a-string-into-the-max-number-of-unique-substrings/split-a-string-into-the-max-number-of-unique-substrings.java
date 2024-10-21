class Solution {
    /**
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public int maxUniqueSplit(String s) {
        HashSet<String> hs = new HashSet<String>();
        int[] max = new int[1];
        solve(0, s, 0, max, hs);
        return max[0];
    }

    private void solve(int i, String s, int current, int[] max, HashSet<String> hs) {
        if (max[0] >= current + (s.length() - i)) {
            // pruning for slight improvement
            return;
        }
        // Base case
        if (i == s.length()) {
            max[0] = Math.max(max[0], current);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String str = s.substring(i, j + 1);
            if (!hs.contains(str)) {
                hs.add(str); // do current step
                solve(j + 1, s, current + 1, max, hs); // explore all possibilities
                hs.remove(str); // undo - backtracking
            }
        }
    }
}
