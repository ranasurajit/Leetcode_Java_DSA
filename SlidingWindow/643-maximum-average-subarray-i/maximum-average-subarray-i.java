class Solution {
    /**
     * Took two pointers i and j = 0 and increment j till window size of 'k' is
     * reached
     * 
     * Window size: (j - i + 1)
     * 
     * when window size < k, then keep increasing j
     * when window size = k, remove arr[i] from sum and
     * maintain this, by incrementing both i an j
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0; // pointer at the start of sliding window
        int j = 0; // pointer at the end of sliding window
        long sum = 0L;
        double maxAvg = (double) Integer.MIN_VALUE;
        double avg = 0.0;
        while (j < n) {
            sum += nums[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                avg = (double) sum / k;
                maxAvg = Math.max(maxAvg, avg);
                // removing element from sum
                sum -= nums[i];
                // slide the window
                i++;
                j++;
            }
        }
        return maxAvg;
    }
}
