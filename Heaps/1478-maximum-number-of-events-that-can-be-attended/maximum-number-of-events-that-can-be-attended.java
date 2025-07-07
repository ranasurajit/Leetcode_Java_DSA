class Solution {
    /**
     * Approach : Using Greedy + Heap (PriorityQueue) Approach
     *
     * TC: O(N x log(N)) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // TC: O(N x log(N))
        int day = events[0][0];
        int i = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(N)
        while (!pq.isEmpty() || i < n) {      // TC: O(N)
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]); // TC: O(log(N))
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return count;
    }
}
