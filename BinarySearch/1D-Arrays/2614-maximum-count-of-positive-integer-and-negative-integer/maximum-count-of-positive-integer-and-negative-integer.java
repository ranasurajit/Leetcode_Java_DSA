class Solution {
    /**
     * Using Normal Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int numNeg = 0;
        int numPos = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] < 0) {
                numNeg++;
            } else if (nums[i] > 0) {
                numPos++;
            }
        }
        return Math.max(numNeg, numPos);
    }
}
