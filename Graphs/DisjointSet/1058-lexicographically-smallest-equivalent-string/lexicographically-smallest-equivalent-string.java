class Solution {
    /**
     * Approach: Disjoint Set Union (DSU) with path compression and custom lexicographic union
     * 
     * TC: O(N + M + 26 * α(26)) ~ O(N + M)
     * SC: O(26 + M) ~ O(M)
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length(); // s1 and s2 are of same lengths
        int m = baseStr.length();
        int[] parent = new int[26];    // SC: O(26)
        for (int i = 0; i < 26; i++) { // TC: O(26)
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {  // TC: O(N)
            union(parent, s1.charAt(i), s2.charAt(i)); // TC: O(1), SC: O(1)
        }
        StringBuilder sb = new StringBuilder(); // SC: O(M)
        for (int i = 0; i < m; i++) { // TC: O(M)
            sb.append((char) ('a' + find(parent, baseStr.charAt(i) - 'a'))); // TC: O(1), SC: O(1)
        }
        return sb.toString();
    }

    /**
     * Using Find By Path Compression Approach
     *
     * TC: O(α(26)) ~ O(1)
     * SC: O(26) ~ O(1)
     */
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    /**
     * Using Union by lexicographically smaller character
     * 
     * TC: O(α(26)) ~ O(1)
     * SC: O(1)
     */
    private void union(int[] parent, char x, char y) {
        int parentX = find(parent, x - 'a'); // TC: O(α(26))
        int parentY = find(parent, y - 'a'); // TC: O(α(26))
        if (parentX == parentY) {
            return;
        }
        if (parentX < parentY) {
            // make x as parent
            parent[parentY] = parentX;
        } else {
            // make y as parent
            parent[parentX] = parentY;
        }
    }
}
