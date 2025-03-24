class Solution {
    /**
     * Approach IV : Optimal Approach (Array Sorting)
     *
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1) - Constant Space
     *
     * Accepted (578 / 578 testcases passed)
     */
    public int countDays(int days, int[][] meetings) {
        int noMeetings = 0;
        int start = 0;
        int end = 0;
        Arrays.sort(meetings, (int[] a, int[] b) -> a[0] - b[0]); // TC: O(N x log(N))
        for (int[] meeting : meetings) { // TC: O(N)
            if (meeting[0] > end) {
                noMeetings += (meeting[0] - end - 1);
            }
            end = Math.max(end, meeting[1]);
        }
        if (days > end) {
            noMeetings += days - end;
        }
        return noMeetings;
    }

    /**
     * Approach III : Optimal Approach (Difference Array Technique with HashMap)
     *
     * TC: O(N + D)
     * SC: O(K), where K << D(days)
     *
     * Memory Limit Exceeded (573 / 578 testcases passed)
     */
    public int countDaysApproachIII(int days, int[][] meetings) {
        // create a difference array of zero elements
        Map<Integer, Integer> diffArr = new HashMap<Integer, Integer>(); // SC: O(K) where K << D
        for (int[] meeting : meetings) { // TC: O(N)
            int start = meeting[0];
            int end = meeting[1];
            diffArr.put(start, diffArr.getOrDefault(start, 0) + 1);
            if (end + 1 <= days) {
                diffArr.put(end + 1, diffArr.getOrDefault(end + 1, 0) - 1);
            }
        }
        int noMeetings = 0;
        long cumulativeSum = 0;
        for (int i = 1; i <= days; i++) { // TC: O(D)
            cumulativeSum += diffArr.getOrDefault(i, 0);
            if (cumulativeSum == 0) {
                noMeetings++;
            }
        }
        return noMeetings++;
    }

    /**
     * Approach II : Better Approach (Difference Array Technique)
     *
     * TC: O(N + D)
     * SC: O(D), where D = days
     *
     * Memory Limit Exceeded (573 / 578 testcases passed)
     */
    public int countDaysApproachII(int days, int[][] meetings) {
        // create a difference array of zero elements
        int[] diffArr = new int[days + 1]; // SC: O(D)
        for (int[] meeting : meetings) { // TC: O(N)
            int start = meeting[0];
            int end = meeting[1];
            diffArr[start]++;
            if (end + 1 <= days) {
                diffArr[end + 1] -= 1;
            }
        }
        int noMeetings = 0;
        long cumulativeSum = 0;
        for (int i = 1; i <= days; i++) { // TC: O(D)
            cumulativeSum += diffArr[i];
            if (cumulativeSum == 0) {
                noMeetings++;
            }
        }
        return noMeetings++;
    }

    /**
     * Approach I : Brute-Force Approach (Using Array Sort Approach)
     *
     * TC: O(N x log(N) + N x K + D) ~ O(N ^ 2) as in worst case K ~ N
     * SC: O(D), where D = days
     *
     * Time Limit Exceeded (563 / 578 testcases passed)
     */
    public int countDaysApproachI(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (int[] a, int[] b) -> a[0] - b[0]); // TC: O(N x log(N))
        int[] occupied = new int[days + 1]; // SC: O(D)
        occupied[0] = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int start = meetings[i][0];
            int end = meetings[i][1];
            for (int j = start; j <= end; j++) { // TC: O(K)
                occupied[j]++;
            }
        }
        int noMeetings = 0;
        for (int i = 1; i <= days; i++) { // TC: O(D)
            if (occupied[i] == 0) {
                noMeetings++;
            }
        }
        return noMeetings++;
    }
}
