class Solution {
    /**
     * Approach II : Using Heaps (PriorityQueue) Approach
     *
     * TC: O(M x log(N) + M x log(M) + 2 x N) ~ O(M x (log(M) + log(N)))
     * SC: O(2 x N) ~ O(N)
     */
    public int mostBooked(int n, int[][] meetings) {
        // sort the meetings with respect to increasing order of start time of meeting
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // TC: O(M x log(M))
        // Min-Heap to store used rooms { endTime, index }
        PriorityQueue<long[]> usedRooms = new PriorityQueue<long[]>((p, q) -> {
            if (p[0] == q[0]) {
                return Long.compare(p[1], q[1]);
            }
            return Long.compare(p[0], q[0]);
        }); // SC: O(N)
        // Min-Heap to store available rooms { index }
        PriorityQueue<Integer> availableRooms = new PriorityQueue<Integer>(); // SC: O(N)
        // Initially all rooms are available
        for (int i = 0; i < n; i++) { // TC: O(N)
            availableRooms.offer(i);
        }
        int[] roomUsageCount = new int[n];
        for (int[] meeting : meetings) { // TC: O(M)
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                long[] roomDetail = usedRooms.poll();
                availableRooms.offer((int) roomDetail[1]); // TC: O(log(N))
            }
            if (!availableRooms.isEmpty()) {
                int roomIndex = availableRooms.poll();
                usedRooms.offer(new long[] { end, roomIndex }); // TC: O(log(N))
                roomUsageCount[roomIndex]++;
            } else {
                long[] earlyUsedRoom = usedRooms.poll();
                usedRooms.offer(new long[] { 
                    earlyUsedRoom[0] + duration,
                    earlyUsedRoom[1]
                }); // TC: O(log(N))
                roomUsageCount[(int) earlyUsedRoom[1]]++;
            }
        }
        int maxUsage = 0;
        int result = -1;
        for (int room = 0; room < n; room++) { // TC: O(N)
            if (roomUsageCount[room] > maxUsage) {
                maxUsage = roomUsageCount[room];
                result = room;
            }
        }
        return result;
    }

    /**
     * Approach I : Using Sorting Approach
     *
     * TC: O(M x N + M x log(M))
     * SC: O(2 x N) ~ O(N)
     */
    public int mostBookedApproachI(int n, int[][] meetings) {
        // sort the meetings with respect to increasing order of start time of meeting
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // TC: O(M x log(M))
        long[] roomsFreeAt = new long[n]; // SC: O(N)
        int[] roomsUsedCount = new int[n]; // SC: O(N)
        for (int[] meeting : meetings) { // TC: O(M)
            int start = meeting[0];
            int end = meeting[1];
            long minTime = Long.MAX_VALUE;
            int roomIndexFree = -1;
            boolean found = false;
            for (int room = 0; room < n; room++) { // TC: O(N)
                if (start >= roomsFreeAt[room]) {
                    // room was found free when the meeting started
                    roomsFreeAt[room] = (long) end;
                    roomsUsedCount[room]++;
                    found = true;
                    break;
                }
                // room was not free, capture the minimum time at which any room will be free
                if (roomsFreeAt[room] < minTime) {
                    minTime = roomsFreeAt[room];
                    roomIndexFree = room;
                }
            }
            if (!found) {
                int diff = end - start;
                roomsFreeAt[roomIndexFree] += diff;
                roomsUsedCount[roomIndexFree]++;
            }
        }
        int maximumUsage = 0;
        int result = -1;
        for (int room = 0; room < n; room++) { // TC: O(N)
            if (maximumUsage < roomsUsedCount[room]) {
                maximumUsage = roomsUsedCount[room];
                result = room;
            }
        }
        return result;
    }
}
