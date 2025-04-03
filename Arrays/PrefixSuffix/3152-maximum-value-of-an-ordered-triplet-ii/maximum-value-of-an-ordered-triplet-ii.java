class Solution {
    /**
     * Approach III : Optimal Approach (Using Array Pre-processing)
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     *
     * Accepted (599 / 599 testcases passed)
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
        long[] leftMax = new long[n];  // SC: O(N)
        long[] rightMax = new long[n]; // TC: O(N)
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) { // TC: O(N)
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        for (int k = n - 2; k >= 0; k--) { // TC: O(N)
            rightMax[k] = Math.max(rightMax[k + 1], nums[k]);
        }
        /**
         * we will calculate the value of triplet at each 
         * index i = (leftMax[i - 1] - nums[i]) * rightMax(i + 1)
         */
        long maxValue = Long.MIN_VALUE;
        for (int j = 1; j < n - 1; j++) { // TC: O(N)
            maxValue = Math.max(maxValue, (leftMax[j - 1] - nums[j]) * rightMax[j + 1]);
        }
        return maxValue < 0 ? 0 : maxValue;
    }

    /**
     * Approach II : Better Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (593 / 599 testcases passed)
     */
    public long maximumTripletValueApproachII(int[] nums) {
        int n = nums.length;
        /**
         * For this value of a triplet to be maximum
         * nums[i] - nums[j]) * nums[k]
         * nums[i] should be 1st maximum and 
         * nums[k] should be 2nd  maximum and
         * nums[j] should be the minimum in array 'nums'
         */
        long maxValue = Long.MIN_VALUE;
        long left = (long) nums[0];
        for (int j = 1; j < n - 1; j++) { // TC: O(N)
            if (left < nums[j]) {
                left = (long) nums[j];
                continue;
            }
            for (int k = j + 1; k < n; k++) { // TC: O(N)
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
     *
     * Time Limit Exceeded (581 / 599 testcases passed)
     */
    public long maximumTripletValueApproachI(int[] nums) {
        int n = nums.length;
        long maxValue = Long.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    maxValue = Math.max(maxValue, (nums[i] - nums[j]) * (long) nums[k]);
                }
            }
        }
        return maxValue < 0 ? 0 : maxValue;
    }
}
