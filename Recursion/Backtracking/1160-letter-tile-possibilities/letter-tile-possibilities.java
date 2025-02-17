class Solution {
    /**
     * Approach I
     * 
     * TC: O(N!)
     * SC: O(N x N!)
     */
    public int numTilePossibilities(String tiles) {
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
