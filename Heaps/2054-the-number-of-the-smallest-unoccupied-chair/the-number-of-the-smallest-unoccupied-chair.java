class Solution {
    /**
     * TC: O(N x log(N))
     * SC: O(N x log(N))
     */
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArr = times[targetFriend][0];
        // use a min-heap based on sorted departure times int[departure time, chairIndex]
        PriorityQueue<int[]> occupiedHeap = new PriorityQueue<int[]>(new Comparator<int[]>() { // SC: O(N)
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> freeChair = new PriorityQueue<Integer>(); // SC: O(N)
        // sort times array based on arrival time
        Arrays.sort(times, (a, b) -> a[0] - b[0]); // SC: O(N x log(N))
        int assignedChair = 0;
        for (int[] time : times) { // TC: O(N x log(N))
            int arrival = time[0];
            int departure = time[1];
            while (!occupiedHeap.isEmpty() && occupiedHeap.peek()[0] <= arrival) {
                freeChair.offer(occupiedHeap.poll()[1]);
            }
            int chairNumber = 0;
            if (freeChair.isEmpty()) {
                // when no free chairs available
                chairNumber = assignedChair;
                assignedChair++;
            } else {
                chairNumber = freeChair.poll();
            }
            if (arrival == targetFriendArr) {
                return chairNumber;
            }
            occupiedHeap.offer(new int[] { departure, chairNumber });
        }
        return -1;
    }
}
