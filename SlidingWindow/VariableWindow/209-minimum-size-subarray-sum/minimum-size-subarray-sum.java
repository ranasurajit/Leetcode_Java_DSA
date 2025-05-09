class Solution {
    /**
     * Approach : Using Sliding Window (Variable Length) Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            total += nums[i];
        }
        if (total < target) {
            // as per constraints 1 <= nums[i] <= 10^4
            return 0;
        }
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int sum = 0;
        int minLength = n;
        while (j < n) { // TC: O(N)
            sum += nums[j];
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                // remove computation from index 'i'
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLength;
    }
}
