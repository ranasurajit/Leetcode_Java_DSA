class Solution {
    /**
     * Approach II (Using Count of Characters and Backtracking)
     * 
     * TC: O(N!)
     * SC: O(N)
     */
    public int numTilePossibilities(String tiles) {
        int[] total = { 0 };
        char[] ch = tiles.toCharArray();
        int n = ch.length;
        int[] count = new int[26];
        for (char c : ch) {
            count[c - 'A']++;
        }
        solveFreq(count, total);
        return total[0] - 1;
    }

    private void solveFreq(int[] count, int[] total) {
        total[0]++;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--; // try
            solveFreq(count, total); // explore
            count[i]++; // backtrack
        }
    }

    /**
     * Approach I (Using Standard Backtracking)
     * 
     * TC: O(N!)
     * SC: O(N x N!)
     */
    public int numTilePossibilitiesApproachI(String tiles) {
        int n = tiles.length();
        boolean[] used = new boolean[n];
        HashSet<String> hs = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        solve(sb, tiles, n, used, hs);
        return hs.size() - 1;
    }

    private void solve(StringBuilder sb, String tiles, int n,
        boolean[] used, HashSet<String> hs) {
        hs.add(sb.toString());
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            // try
            used[i] = true;
            sb.append(tiles.charAt(i));
            // explore
            solve(sb, tiles, n, used, hs);
            // backtrack - undo
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}
