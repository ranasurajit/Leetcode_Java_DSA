class Solution {
    /**
     * Using Array Pre-processing
     *
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int longestMonotonicSubarray(int[] nums) {
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
