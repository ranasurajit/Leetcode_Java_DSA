class Solution {
    /**
     * Approach : Using Sorting Approach
     *
     * TC: O(M x N + M x log(M))
     * SC: O(2 x N) ~ O(N)
     */
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;
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
