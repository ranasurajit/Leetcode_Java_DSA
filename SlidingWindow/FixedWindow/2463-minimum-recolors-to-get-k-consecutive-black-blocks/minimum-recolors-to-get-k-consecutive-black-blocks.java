class Solution {
    /**
     * Approach II : Using Sliding Window (Fixed Size) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int minCountWhites = n;
        int countWhites = 0;
        while (j < n) { // TC: O(N)
            if (blocks.charAt(j) == 'W') {
                countWhites++;
            }
            if (j - i + 1 < k) {
                // sliding window size is not met
                j++;
            } else if (j - i + 1 == k) {
                // capture the minimum whites encountered
                minCountWhites = Math.min(minCountWhites, countWhites);
                // remove the calculation before sliding to next window
                if (blocks.charAt(i) == 'W') {
                    countWhites--;
                }
                // slide the window maintaining the k size window
                i++;
                j++;
            }
        }
        // minimum recolors needed to minimum white blocks in continuity of k items
        return minCountWhites;
    }
}
