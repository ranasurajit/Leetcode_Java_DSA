class Solution {
    /**
     * Approach : Using Min-Heap (PriorityQueue) Approach
     *
     * TC: O(M x log(M)) + O(N x log(N)) + O(M x log(N)) + O(N) ~ O(M x log(M) + (M + N) x log(N))
     * SC: O(N) + O(N) + O(N) ~ O(N)
     */
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // TC: O(M x log(M))
        // we need a Min-Heap (PriorityQueue) to store unused rooms
        PriorityQueue<int[]> usedRooms = new PriorityQueue<int[]>((p, q) -> {
            if (p[0] == q[0]) {
                return p[1] - q[1];
            }
            return p[0] - q[0];
        }); // SC: O(N)
        // we need a Min-Heap (PriorityQueue) to store available rooms
        PriorityQueue<Integer> availableRooms = new PriorityQueue<Integer>(); // SC: O(N)
        // filling up all the available room to start the process
        for (int i = 0; i < n; i++) { // TC: O(N)
            availableRooms.offer(i); // TC: O(log(N))
        }
        int[] usage = new int[n]; // SC: O(N)
        for (int[] event : meetings) { // TC: O(M)
            int start = event[0];
            int end = event[1];
            int duration = end - start;
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                availableRooms.offer(usedRooms.poll()[1]); // TC: O(log(N))
            }
            if (!availableRooms.isEmpty()) {
                int roomIdx = availableRooms.poll();
                usage[roomIdx]++;
                usedRooms.offer(new int[] { end, roomIdx }); // TC: O(log(N))
            } else {
                int[] earlyUsedRoom = usedRooms.poll();
                usedRooms.offer(new int[] { 
                    earlyUsedRoom[0] + duration,
                    earlyUsedRoom[1]
                }); // TC: O(log(N))
                usage[earlyUsedRoom[1]]++;
            }
        }
        int maxUsage = 0;
        int roomIndex = -1;
        for (int room = 0; room < n; room++) { // TC: O(N)
            if (maxUsage < usage[room]) {
                maxUsage = usage[room];
                roomIndex = room;
            }
        }
        return roomIndex;
    }
}
