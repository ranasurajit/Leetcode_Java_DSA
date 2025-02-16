class Solution {
    /**
     * Using Backtracking Approach
     *
     * TC: O(N!)
     * SC: O(2 x N) ~ O(N)
     */
    public int[] constructDistancedSequence(int n) {
        if (n == 1) {
            return new int[] { 1 };
        }
        // total size of result = 2 x n - 1 (2 x [1..n] - 1 (1 can occur once only))
        int size = 2 * n - 1;
        boolean[] used = new boolean[size]; // to mark which number has been used
        int[] result = new int[size];
        Arrays.fill(result, -1); // to mark if the index of result is filled
        solve(0, n, result, used);
        return result;
    }

    private boolean solve(int idx, int n, int[] result, boolean[] used) {
        // base case
        if (idx >= result.length) {
            // we have explored everything and result is already populated
            return true;
        }
        if (result[idx] != -1) {
            // the index 'idx' is filled already so explore next index (idx + 1)
            return solve(idx + 1, n, result, used);
        }
        // try all possibilities
        for (int num = n; num >= 1; num--) {
            if (used[num]) {
                continue;
            }
            // try
            used[num] = true;
            result[idx] = num;
            // explore all possibilities
            if (num == 1) {
                // 1 can have only 1 occurence
                if (solve(idx + 1, n, result, used)) {
                    return true;
                }
            } else {
                // all numbers except 1 can have 2nd occurence
                int j = idx + result[idx]; // 2nd occurence index
                // validate if j is valid
                if (j < result.length && result[j] == -1) {
                    result[j] = num;
                    if (solve(idx + 1, n, result, used)) {
                        return true;
                    }
                    // undo as we made a wrong choice so reverting it
                    result[j] = -1;
                }
            }
            // backtrack - undo and explore
            used[num] = false;
            result[idx] = -1;
        }
        return false;
    }
}
