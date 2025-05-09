class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Length) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        double maxSum = (double) Integer.MIN_VALUE;
        double sum = 0d;
        while (j < n) { // TC: O(N)
            sum += nums[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // sliding window length is met
                maxSum = Math.max(maxSum, sum);
                // remove computation from index 'i';
                sum -= nums[i];
                // slide the window to next valid window
                i++;
                j++;
            }
        }
        return maxSum / k;
    }
}
