class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Accepted (167 / 167 testcases passed)
     */
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0L;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        long sum = 0L;
        while (j < n) { // TC: O(N)
            sum += nums[j];
            while (sum * (j - i + 1) >= k) {
                // remove calculation from nums[i];
                sum -= nums[i];
                // shrink the window
                i++;
            }
            if (sum * (j - i + 1) < k) {
                // we need to consider all the sub-arrays in the range [i..j]
                count += (j - i + 1);
            }
            j++;
        }
        return count;
    }

    /**
     * Approach : Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (159 / 167 testcases passed)
     */
    public long countSubarraysBruteForce(int[] nums, long k) {
        int n = nums.length;
        long count = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            long sum = 0L;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                // length of sub-array = j - i + 1
                if (sum * (j - i + 1) < k) {
                    count++;
                }
            }
        }
        return count;
    }
}
