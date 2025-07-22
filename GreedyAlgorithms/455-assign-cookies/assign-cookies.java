class Solution {
    /**
     * Approach : Using Greedy + Two Pointers Approach
     *
     * TC: O(M x log(M)) + O(N x log(N)) + O(Min(M, N))
     * SC: O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        /**
         * We will sort the greed factor 'g' and cookie size 's' and check if
         * maximum value greed factor of child is satisfied with maximum value
         * of cookie size
         */
        Arrays.sort(g); // TC: O(M x log(M))
        Arrays.sort(s); // TC: O(N x log(N))
        // Using Two Pointers Approach
        int p = m - 1; // pointer at the end of array 'g'
        int q = n - 1; // pointer at the end of array 's'
        int contentedChildCount = 0;
        while (p >= 0 && q >= 0) { // TC: O(Min(M, N))
            if (g[p] <= s[q]) {
                contentedChildCount++;
                q--;
            }
            p--;
        }
        return contentedChildCount;
    }
}
