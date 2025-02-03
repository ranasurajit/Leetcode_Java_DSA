class Solution {
    /**
     * Approach II : Without using space
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int currentInc = 1;
        int currentDec = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (nums[i] > nums[i - 1]) {
                currentInc++;
                currentDec = 1;
            } else if (nums[i] < nums[i - 1]) {
                currentDec++;
                currentInc = 1;
            } else {
                currentInc = 1;
                currentDec = 1;
            }
            maxLength = Math.max(maxLength, Math.max(currentInc, currentDec));
        }
        return maxLength;
    }

    /**
     * Approach I : Using Array Pre-processing
     *
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int longestMonotonicSubarrayApproachI(int[] nums) {
        int n = nums.length;
        int[] incArr = new int[n]; // SC: O(N)
        int[] decArr = new int[n]; // SC: O(N)
        Arrays.fill(incArr, 1);
        Arrays.fill(decArr, 1);
        int maxInc = 1;
        int maxDec = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (nums[i] > nums[i - 1]) {
                incArr[i] = incArr[i - 1] + 1;
            } else if (nums[i] < nums[i - 1]) {
                decArr[i] = decArr[i - 1] + 1;
            } else {
                incArr[i] = 1;
                decArr[i] = 1;
            }
            maxInc = Math.max(maxInc, incArr[i]);
            maxDec = Math.max(maxDec, decArr[i]);
        }
        return Math.max(maxInc, maxDec);
    }
}
