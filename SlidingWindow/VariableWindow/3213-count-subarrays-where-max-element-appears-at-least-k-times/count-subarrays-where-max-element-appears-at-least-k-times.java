class Solution {
    /**
     * Approach II : Sliding Window (Variable Size) Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     *
     * Time Limit Exceeded (622 / 633 testcases passed)
     */
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            max = Math.max(max, nums[i]);
        }
        long count = 0L;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int countMax = 0;
        while (j < n) { // TC: O(N)
            countMax += nums[j] == max ? 1 : 0;
            while (countMax >= k) {
                count += (n - j);
                // remove calculation from nums[i]
                if (nums[i] == max) {
                    countMax -= 1;
                }
                // shrink the window
                i++;
            }
            j++;
        }
        return count;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N + N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (622 / 633 testcases passed)
     */
    public long countSubarraysBruteForce(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            max = Math.max(max, nums[i]);
        }
        long count = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int countMax = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                countMax += nums[j] == max ? 1 : 0;
                if (countMax >= k) {
                    count++;
                }
            }
        }
        return count;
    }
}
