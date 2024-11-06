class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int numSetBits = Integer.bitCount(nums[0]);
        int segmentMin = nums[0];
        int segmentMax = nums[0];
        int prevSegmentMax = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {                      // TC: O(N)
            if (Integer.bitCount(nums[i]) == numSetBits) {
                segmentMin = Math.min(segmentMin, nums[i]);
                segmentMax = Math.max(segmentMax, nums[i]);
            } else {
                // start of a new segment
                if (prevSegmentMax > segmentMin) {
                    // if one segment overlaps the other
                    return false;
                }
                prevSegmentMax = segmentMax;
                segmentMin = nums[i];
                segmentMax = nums[i];
                numSetBits = Integer.bitCount(nums[i]);
            }
        }
        if (prevSegmentMax > segmentMin) {
            // if one segment overlaps the other
            return false;
        }
        return true;
    }
}
