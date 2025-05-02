class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] pattern = new char[n + 2]; // SC: O(N)
        pattern[0] = 'L';
        pattern[n + 1] = 'R';
        // effect on dominoes remain unchanged after setting 'L' and 'R' to both extremes
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            pattern[i] = dominoes.charAt(i - 1);
        }
        int j = 0;
        int k = 1;
        while (k < n + 2) { // TC: O(N)
            while (pattern[k] == '.') {
                k++;
            }
            // at this point, j and k will be having either 'L' or 'R'
            if (k - j > 1) {
                compute(pattern, j, k);  // contributes ammorized time complexity
            }
            j = k;
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(pattern[i]);
        }
        return sb.toString();
    }

    private void compute(char[] pattern, int p, int q) {
        if (pattern[p] == 'L' && pattern[q] == 'L') {
            for (int i = p + 1; i < q; i++) {
                pattern[i] = 'L';
            }
        } else if (pattern[p] == 'R' && pattern[q] == 'R') {
            for (int i = p + 1; i < q; i++) {
                pattern[i] = 'R';
            }
        } else if (pattern[p] == 'L' && pattern[q] == 'R') {
            return;
        } else if (pattern[p] == 'R' && pattern[q] == 'L') {
            int dotsCount = q - p - 1;
            int mid = (p + q) / 2;
            // if size is even, set half as 'R' and half as 'L'
            for (int i = p; i <= mid; i++) {
                if (pattern[i] == '.') {
                    pattern[i] = 'R';
                }
            }
            for (int i = mid + 1 ; i < q; i++) {
                if (pattern[i] == '.') {
                    pattern[i] = 'L';
                }
            }
            if ((dotsCount & 1) != 0) {
                // odd size so set half as 'R' and half as 'L' and mid as '.'
                pattern[mid] = '.';
            }
        }
    }
}
