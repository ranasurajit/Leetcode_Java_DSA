class Solution {
    /**
     * Using Sweep-Line Algorithm
     *
     * TC: O(N x log(N))
     * SC: O(N)
     * 
     * @param intervals
     * @return
     */
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, Integer> events = new TreeMap<Integer, Integer>();
        // minimum number of groups is the maximum number of overlapping intervals
        return getMaximumOverlaps(intervals, events);
    }

    /**
     * TC: O(N x log(N))
     * SC: O(1)
     * 
     * @param intervals
     * @param events
     * @return
     */
    private int getMaximumOverlaps(int[][] intervals, 
        TreeMap<Integer, Integer> events) {
        for (int[] interval : intervals) {                    // TC: O(N)
            events.put(interval[0],
                events.getOrDefault(interval[0], 0) + 1);     // TC: O(log(N))
            events.put(interval[1] + 1, 
                events.getOrDefault(interval[1] + 1, 0) - 1); // TC: O(log(N))
        }
        int maxGroups = 0;
        int currentGroups = 0;
        for (Integer key : events.keySet()) {                 // TC: O(2 x N)
            currentGroups += events.get(key);                 // TC: O(log(N))
            maxGroups = Math.max(maxGroups, currentGroups);
        }
        return maxGroups;
    }
}
