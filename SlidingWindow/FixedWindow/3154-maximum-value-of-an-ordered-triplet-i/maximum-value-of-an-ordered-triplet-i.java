class Solution {
    /**
     * Approach II : Better Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        /**
         * For this value of a triplet to be maximum
         * nums[i] - nums[j]) * nums[k]
         * nums[i] should be 1st maximum and 
         * nums[k] should be 2nd  maximum and
         * nums[j] should be the minimum in array 'nums'
         */
        long left = nums[0];
        long maxValue = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            if (nums[j] > left) {
                left = nums[j];
                continue;
            }
            for (int k = j + 1; k < n; k++) {
                maxValue = Math.max(maxValue, (left - nums[j]) * (long) nums[k]);
            }
        }
        return maxValue < 0 ? 0 : maxValue;
    }

    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public long maximumTripletValueApproachI(int[] nums) {
        int n = nums.length;
        long maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 3; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    maxValue = Math.max(maxValue, (nums[i] - nums[j]) * (long) nums[k]);
                }
            }
        }
        return maxValue < 0 ? 0 : maxValue;
    }
}
