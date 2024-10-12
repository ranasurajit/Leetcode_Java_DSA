class Solution {
    /**
     * TC: O(3 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minGroups(int[][] intervals) {
        // sort the intervals based on start time
        Arrays.sort(intervals, new Comparator<int[]>() { // TC: O(N x log(N))
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // add the end time to the min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(N)
        // loop through the intervals to form groups
        for (int[] interval : intervals) { // TC: O(N)
            int start = interval[0];
            int end = interval[1];
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll(); // TC: O(log(N))
            }
            pq.offer(end); // TC: O(log(N))
        }
        // number of groups = size of PriorityQueue
        return pq.size();
    }
}
