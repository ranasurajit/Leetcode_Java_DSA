class Solution {
    /**
     * Approach : Using Line Sweep Algorithm
     *
     * TC: O(2 x N x log(N) + 2 x N x log(2 x N)) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> eventsMap = new TreeMap<Integer, Integer>(); // SC: O(2 x N)
        for (int[] time : intervals) { // TC: O(N)
            int start = time[0];
            int end = time[1];
            eventsMap.put(start, eventsMap.getOrDefault(start, 0) + 1); // TC: O(log(N))
            /**
             * as endTime is included as [startTime, endTime]
             * is full-open interval i.e. startTime <= x <= endTime
             */
            eventsMap.put(end + 1, eventsMap.getOrDefault(end + 1, 0) - 1); // TC: O(log(N))
        }
        int currentOverlaps = 0;
        int maxOverlaps = 0;
        for (Integer key : eventsMap.keySet()) { // TC: O(2 x N)
            currentOverlaps += eventsMap.get(key); // TC: O(log(2 x N))
            maxOverlaps = Math.max(maxOverlaps, currentOverlaps);
        }
        /**
         * maximum overlaps will tell how many minimum groups are needed
         * so that no two intervals that are in the same group intersect each other
         */
        return maxOverlaps;
    }
}
