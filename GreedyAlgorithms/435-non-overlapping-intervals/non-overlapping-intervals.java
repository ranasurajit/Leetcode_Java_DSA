class Solution {
    /**
     * Approach : Using Sorting + Simulation Approach
     *
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // sorting the intervals in ascending order of end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // TC: O(N x log(N))
        int countNonOverlaps = 1;
        int lastEndTime = intervals[0][1];
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (intervals[i][0] >= lastEndTime) {
                countNonOverlaps++;
                lastEndTime = intervals[i][1];
            }
        }
        return n - countNonOverlaps;
    }
}
