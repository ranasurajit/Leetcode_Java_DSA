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
}
