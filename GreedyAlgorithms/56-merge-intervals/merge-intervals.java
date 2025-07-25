class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N x log(N)) + O(N) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // TC: O(N x log(N))
        List<int[]> mergedIntervals = new ArrayList<int[]>(); // SC: O(N)
        int[] current = intervals[0];
        mergedIntervals.add(current);
        for (int i = 1; i < n; i++) { // TC: O(N)
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                // overlap
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                mergedIntervals.add(current);
            }
        }
        int size = mergedIntervals.size();
        int[][] merged = new int[size][2];
        for (int i = 0; i < size; i++) { // TC: O(N)
            merged[i] = mergedIntervals.get(i);
        }
        return merged;
    }
}
