class Solution {
    /**
     * Approach : Using Array Prefix-Suffix Approach
     *
     * TC: O(N) + O(M) + O(M) + O(M) ~ O(N + M)
     * SC: O(M) + O(M) + O(M) ~ O(M)
     */
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<Integer>(); // SC: O(M)
        gaps.add(startTime[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);
        // Using Array Pre-processing
        int m = gaps.size();
        int[] gapsRight = new int[m];      // SC: O(M)
        for (int i = m - 2; i >= 0; i--) { // TC: O(M)
            gapsRight[i] = Math.max(gapsRight[i + 1], gaps.get(i + 1));
        }
        int[] gapsLeft = new int[m];  // SC: O(M)
        for (int i = 2; i < m; i++) { // TC: O(M)
            gapsLeft[i] = Math.max(gapsLeft[i - 1], gaps.get(i - 2));
        }
        int maxTime = 0;
        for (int i = 1; i < m; i++) { // TC: O(M)
            int meetingTime = endTime[i - 1] - startTime[i - 1];
            if (meetingTime <= Math.max(gapsLeft[i], gapsRight[i])) {
                // this is when meeting is shifted entirely
                maxTime = Math.max(maxTime, gaps.get(i) + gaps.get(i - 1) + meetingTime);
            }
            // this is when meeting is just shifted within the gaps available
            maxTime = Math.max(maxTime, gaps.get(i) + gaps.get(i - 1));
        }
        return maxTime;
    }
}
