class Solution {
    /**
     * Approach II : Using Bit-Manipulation Approach
     *
     * TC: O(2 x 32 x N) ~ O(N) 
     * SC: O(32) ~ O(1)
     *
     * Accepted (59 / 59 testcases passed)
     */
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] lastSetBit = new int[32];           // SC: O(32)
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {        // TC: O(N)
            for (int bit = 0; bit < 32; bit++) {  // TC: O(32)
                if ((nums[i] & (1 << bit)) != 0) {
                    lastSetBit[bit] = i;
                }
            }
            int maxBit = i;
            for (int bit = 0; bit < 32; bit++) {  // TC: O(32)
                maxBit = Math.max(maxBit, lastSetBit[bit]);
            }
            result[i] = maxBit - i + 1;
        }
        return result;
    }

    /**
     * Approach : Using Brute-Force Simulation Approach
     *
     * TC: O(N x N)
     * SC: O(1)
     *
     * Time Limit Exceeded (56 / 59 testcases passed)
     */
    public int[] smallestSubarraysBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int maxOR = -1;
            int currentOR = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                currentOR |= nums[j];
                if (maxOR < currentOR) {
                    maxOR = currentOR;
                    result[i] = j - i + 1;
                }
            }
        }
        return result;
    }
}
