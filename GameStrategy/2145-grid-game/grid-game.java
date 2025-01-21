class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long rowSum1 = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            rowSum1 += grid[0][i];
        }
        /**
         * robot 1 will partition the path based on that
         * robot 2 will pick maximum from left or right
         */
        long answer = Long.MAX_VALUE;
        long leftChoiceSum = 0L;
        long rightChoiceSum = rowSum1;
        for (int rc = 0; rc < n; rc++) { // TC: O(N)
            // if robot 1 chooses column = rc for it's strategy
            leftChoiceSum += rc > 0 ? grid[1][rc - 1] : 0;
            rightChoiceSum -= grid[0][rc];
            long choice = Math.max(leftChoiceSum, rightChoiceSum);
            answer = Math.min(answer, choice);
        }
        return answer;
    }
}
