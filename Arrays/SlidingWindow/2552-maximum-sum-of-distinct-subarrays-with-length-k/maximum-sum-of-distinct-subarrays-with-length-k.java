class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0L;
        long currentSum = 0L;
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            // duplicate check and shrink
            while (!hs.isEmpty() && hs.contains(nums[j])) {
                currentSum = currentSum - nums[i];
                hs.remove(nums[i]);
                i++;
            }
            // add current element
            currentSum = currentSum + nums[j];
            hs.add(nums[j]);
            /*
             * check if window size == k then capture the maxSum and 
             * remove the 1st element of window
             */
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = currentSum - nums[i];
                hs.remove(nums[i]);
                i++;
            }
        }
        return maxSum;
    }
}
