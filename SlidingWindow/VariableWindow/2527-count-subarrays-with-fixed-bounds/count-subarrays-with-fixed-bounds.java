class Solution {
    /**
     * Approach : Using Sliding Window Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minKPos = -1;
        int maxKPos = -1;
        int invalidPos = -1;
        long count = 0L;
        // we will always look towards left from index 'i' for getting all positions
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == minK) {
                minKPos = i;
            }
            if (nums[i] == maxK) {
                maxKPos = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                invalidPos = i;
            }
            int temp = Math.min(minKPos, maxKPos) - invalidPos;
            count += temp < 0 ? 0 : temp;
        }
        return count;
    }
}
