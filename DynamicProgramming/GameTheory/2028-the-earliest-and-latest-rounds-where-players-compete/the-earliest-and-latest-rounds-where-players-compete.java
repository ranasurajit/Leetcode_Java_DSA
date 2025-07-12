class Solution {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int N;
    private int first;
    private int second;

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O((2 ^ N) x N ^ 2)
     * SC: O(N ^ 2)
     */
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        N = n - 1;
        first = firstPlayer - 1;
        second = secondPlayer - 1;
        int mask = (1 << n) - 1; // we need to create a mask 11111111111 where n = 11
        solveRecursion(mask, 1, 0, N);
        return new int[] { min, max };
    }

    /**
     * Using Recursion Approach
     *
     * TC: O((2 ^ N) x N ^ 2)
     * SC: O(N ^ 2)
     */
    private void solveRecursion(int mask, int round, int i, int j) {
        // Base Case
        if (i >= j) {
            // we need to start a new round reseting i and j
            solveRecursion(mask, round + 1, 0, N);
        } else if ((mask & (1 << i)) == 0) {
            // ith bit is off that means we need to increment i as this denotes ith player is defeated
            solveRecursion(mask, round, i + 1, j);
        } else if ((mask & (1 << j)) == 0) {
            // jth bit is off that means we need to decrement j as this denotes jth player is defeated
            solveRecursion(mask, round, i, j - 1);
        } else if (i == first && j == second) {
            // as i < j and first < second
            min = Math.min(min, round);
            max = Math.max(max, round);
        } else {
            if (i != first && i != second) {
                // then ith player might get defeated so set ith bit to 0
                solveRecursion(mask ^ (1 << i), round, i + 1, j - 1);
            }
            if (j != first && j != second) {
                // then jth player might get defeated so set jth bit to 0
                solveRecursion(mask ^ (1 << j), round, i + 1, j - 1);
            }
        }
    }
}
