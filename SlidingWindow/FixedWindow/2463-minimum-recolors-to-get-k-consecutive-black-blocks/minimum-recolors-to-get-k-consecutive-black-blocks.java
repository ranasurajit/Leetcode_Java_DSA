class Solution {
    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(K x (N - K))
     * SC: O(1)
     */
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minCountWhites = n;
        for (int i = 0; i < n - k + 1; i++) { // TC: O(N - K)
            int countWhites = 0;
            for (int j = i; j < i + k; j++) { // TC: O(K)
                countWhites += blocks.charAt(j) == 'W' ? 1 : 0; 
            }
            minCountWhites = Math.min(minCountWhites, countWhites);
        }
        // minimum recolors needed to minimum white blocks in continuity of k items
        return minCountWhites;
    }
}
