class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> intervalList = new ArrayList<int[]>(); // SC: O(N)
        // adding the non-overlapping left intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            intervalList.add(intervals[i]);
            i++;
        }
        // merging and adding overlapping middle intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        intervalList.add(newInterval);
        // adding the non-overlapping right intervals
        while (i < n) {
            intervalList.add(intervals[i]);
            i++;
        }
        int size = intervalList.size();
        int[][] result = new int[size][2];
        for (i = 0; i < size; i++) { // TC: O(N)
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
