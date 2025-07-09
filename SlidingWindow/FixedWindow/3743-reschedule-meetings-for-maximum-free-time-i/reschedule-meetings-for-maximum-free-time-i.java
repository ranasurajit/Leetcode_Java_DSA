class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Size) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<Integer>(); // SC: O(N)
        gaps.add(startTime[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);
        // if we move k meetings, then we will create space of (k + 1), so sliding window size = (k + 1)
        k = k + 1;
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxDuration = 0;
        while (j < gaps.size()) { // TC: O(N)
            sum += gaps.get(j);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxDuration = Math.max(maxDuration, sum);
                // remove computation from index 'i'
                sum -= gaps.get(i);
                // slide the window
                i++;
                j++;
            }
        }
        return maxDuration;
    }
}
